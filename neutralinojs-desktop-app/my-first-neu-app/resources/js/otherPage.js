


/**
 * @param {HTMLElement} htmlElement
 * @param {String} backgroundHexidecimalColor in the format of '#rrggbb' (e.g. #000000 = black)
 */
function changeButtonBgColor(htmlElement, backgroundHexidecimalColor) {
    console.log(`changeButtonBgColor triggered with args: ${htmlElement} and '${backgroundHexidecimalColor}'`)
    htmlElement.style.backgroundColor = backgroundHexidecimalColor;
}

const myButton = document.getElementById("myButton");
myButton.addEventListener("click", clickEvent => {
    const input = document.getElementById("colorInput");
    let newColor;
    if (input && input.value.length > 0) {
        console.log(`${input}`);
        newColor = input.value;
    } else {
        newColor = "#000000"; // Fallback value (black).
    }

    changeButtonBgColor(clickEvent.target, newColor)
})
