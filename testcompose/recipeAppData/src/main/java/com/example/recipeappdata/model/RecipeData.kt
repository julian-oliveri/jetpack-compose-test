package com.example.recipeappdata.model

import com.google.gson.annotations.SerializedName

data class RecipeData (
    @SerializedName("uri")
    val uri: String,
    @SerializedName("label")
    val label: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("ingredients")
    val ingredients: List<RecipeIngredients>,
    @SerializedName("instructions")
    val instructions: List<String>?,
    val extId: String
)

fun RecipeData.toExtId() = RecipeData(uri, label, image, url, ingredients, instructions, uri.substringAfter("recipe_"))
//{
// http://www.edamam.com/ontologies/edamam.owl#recipe_bdbd520ef98fb99c4b0951e6a9fc6934
// bdbd520ef98fb99c4b0951e6a9fc6934
//
//
//    "from": 0,
//    "to": 0,
//    "count": 0,
//    "_links":
//    {
//        "self": {
//        "href": "string",
//        "title": "string"
//    },
//        "next": {
//        "href": "string",
//        "title": "string"
//    }
//    },
//    "hits": [
//    {
//        "recipe": {
//        "uri": "string",
//        "label": "string",
//        "image": "string",
//        "images": {
//        "THUMBNAIL": {
//        "url": "string",
//        "width": 0,
//        "height": 0
//    },
//        "SMALL": {
//        "url": "string",
//        "width": 0,
//        "height": 0
//    },
//        "REGULAR": {
//        "url": "string",
//        "width": 0,
//        "height": 0
//    },
//        "LARGE": {
//        "url": "string",
//        "width": 0,
//        "height": 0
//    }
//    },
//        "source": "string",
//        "url": "string",
//        "shareAs": "string",
//        "yield": 0,
//        "dietLabels": [
//        "string"
//        ],
//        "healthLabels": [
//        "string"
//        ],
//        "cautions": [
//        "string"
//        ],
//        "ingredientLines": [
//        "string"
//        ],
//        "ingredients": [
//        {
//            "text": "string",
//            "quantity": 0,
//            "measure": "string",
//            "food": "string",
//            "weight": 0,
//            "foodId": "string"
//        }
//        ],
//        "calories": 0,
//        "glycemicIndex": 0,
//        "totalCO2Emissions": 0,
//        "co2EmissionsClass": "A+",
//        "totalWeight": 0,
//        "cuisineType": [
//        "string"
//        ],
//        "mealType": [
//        "string"
//        ],
//        "dishType": [
//        "string"
//        ],
//        "instructions": [
//        "string"
//        ],
//        "tags": [
//        "string"
//        ],
//        "externalId": "string",
//        "totalNutrients": {},
//        "totalDaily": {},
//        "digest": [
//        {
//            "label": "string",
//            "tag": "string",
//            "schemaOrgTag": "string",
//            "total": 0,
//            "hasRDI": true,
//            "daily": 0,
//            "unit": "string",
//            "sub": {}
//        }
//        ]
//    },
//        "_links": {
//        "self": {
//        "href": "string",
//        "title": "string"
//    },
//        "next": {
//        "href": "string",
//        "title": "string"
//    }
//    }
//    }
//    ]
//}