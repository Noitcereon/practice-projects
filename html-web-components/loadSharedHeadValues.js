document.head.insertAdjacentHTML("afterbegin",
    ` 
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
`)


const cssLink = document.createElement("link");
cssLink.rel = "stylesheet";
cssLink.href = "css/style.css";

/* Adding scripts without innerHtml, because scripts cannot be added via innerHtml.
 * See https://developer.mozilla.org/en-US/docs/Web/API/Element/innerHTML#security_considerations
 */
const defaultHeaderScript = document.createElement("script")
defaultHeaderScript.src = "DefaultHeader.js";

/* Add elements to head */
document.head.appendChild(defaultHeaderScript)
document.head.appendChild(cssLink)
