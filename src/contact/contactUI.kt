package contact

import react.RBuilder
import react.dom.div

fun RBuilder.contactUI(){
    for (item in Contact.all())
        div {
            +"${item.name}"
        }
}