// Define a custom HTML element called <navigation-component>
class NavigationComponent extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({mode: 'open'});
        this.shadowRoot.innerHTML = `
                <link rel="stylesheet" href="https://unpkg.com/tailwindcss@2.2.19/dist/tailwind.min.css"/>
                <div class="space-x-5 text-center pb-10">
                    <a href="/shop/admin/products">Products</a>
                    <a href="/shop/admin/categories">Categories</a>
                            <a href="/shop/admin/accounts">Accounts</a>

                    <a href="/shop/logout">Logout</a>
                </div>
        `;
    }

}

// Register the custom element
customElements.define('navigation-component', NavigationComponent);
