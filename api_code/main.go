package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"

	"github.com/schollz/ingredients"
	"github.com/schollz/instructions"
)

func returnJSON(w http.ResponseWriter, r *http.Request) {
	url, ok := r.URL.Query()["url"]

	if !ok || len(url[0]) < 1 {
		log.Println("URL parameter is missing")
		return
	}

	type Response struct {
		Ingredients []ingredients.Ingredient `json:"ingredients"`
		Directions  []string                 `json:"directions"`
		Origin      string                   `json:"origin"`
	}

	log.Println("url is: " + url[0])

	// get receipe which contains ingredients array. Self contained function which reads the page within the function
	recipe, _ := ingredients.NewFromURL(url[0])

	// get directions as an array of strings. This function needs to be passed the html code of the page as a string unlike the previous function so some additional helper code is needed
	resp, err := http.Get(url[0])
	// handle the error if there is one
	if err != nil {
		panic(err)
	}
	// do this now so it won't be forgotten
	defer resp.Body.Close()
	// reads html as a slice of bytes
	html, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		panic(err)
	}

	i, err := instructions.Parse(string(html))

	// put ingredients and directions together into response array and send back as JSON
	var re Response
	re.Ingredients = recipe.IngredientList().Ingredients
	re.Directions = i
	re.Origin = url[0]

	json.NewEncoder(w).Encode(re)

	b, err := json.Marshal(re)
	if err != nil {
		fmt.Printf("Error :%s", err)
		return
	}
	fmt.Println(string(b))

}

func main() {
	fmt.Println("Starting server on port 8080")
	http.HandleFunc("/", returnJSON)
	log.Fatal(http.ListenAndServe(":8080", nil))
}
