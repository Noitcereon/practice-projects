class DefaultHeader extends HTMLElement {
    connectedCallback() {
        console.log("defaultHeader connected");
        const shadow = this.attachShadow({ mode: "open" });

        const defaultHeader = document.createElement("header")
        defaultHeader.innerHTML = `
                <nav>
                    <ul>
                         <li>Item 1</li>
                         <li>Item 2</li>
                         <li>Item 3</li>
                    </ul>
                </nav>
        `

        shadow.appendChild(defaultHeader)
    }

    disconnectedCallback() {
        console.log("defaultHeader disconnected");
    }

    adoptedCallback() {
        console.log("defaultHeader adopted");
    }

    attributeChangedCallback(name, oldValue, newValue) {
        console.log("defaultHeader attributeChangedCallback", name, oldValue, newValue);
    }
}

/*
* Name requirements for web component can be found here: https://developer.mozilla.org/en-US/docs/Web/API/CustomElementRegistry/define#valid_custom_element_names
* Briefly: must be all-lowercase, must contain a hyphen/dash '-', cannot not start with a number and cannot be named reserved names.
*/
customElements.define("default-header", DefaultHeader);
