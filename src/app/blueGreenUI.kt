package app

import kotlinext.js.js
import kotlinx.html.style
import kotlinx.html.title
import react.RBuilder
import react.dom.div
import react.dom.h1


fun RBuilder.blueGreenUI() {
    div {
        attrs.style = js {
            margin = "auto"
            width = "50%"
            border = "3px solid grey"
            padding = "10px"

        }

        h1 {
            attrs.style = js {
                margin = "auto"
                width = "100%"
                padding = "10px"

            }
            +"BlueGreen Deployment"
        }


        // Circle
        div {
            attrs.title = "BlueGreen"
            attrs.style = js {
                 background = "green"
//                background = "blue"
                height = "200px"
                width = "200px"
                borderradius = "50%"
                borderRadius = "50%"
                display = "inline-block"
            }
        }
    }
}
