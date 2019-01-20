package index

import app.blueGreenUI
import kotlinext.js.require
import kotlinext.js.requireAll
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement
import react.dom.render
import kotlin.browser.document
import kotlin.browser.window

fun main(args: Array<String>) {
    requireAll(require.context("src", true, js("/\\.css$/")))

    val rootDiv = document.getElementById("root")

    document.title = "Blue";

    render(rootDiv) {
       blueGreenUI()
    }
}
