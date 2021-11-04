import React, { Component } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { Routes, Route, Link } from "react-router-dom";

import ProductList from "./components/ProductList";
import AddProduct from "./components/AddProduct";
import AddSeller from "./components/AddSeller";

class App extends Component {
    render() {
        return (
            <div>
                <nav className="navbar navbar-expand navbar-dark bg-dark">
                    <a href="/products" className="navbar-brand">
                        Inventory
                    </a>
                    <div className="navbar-nav mr-auto">
                        <li className="nav-item">
                            <Link to={"/products"} className="nav-link">
                                All Products
                            </Link>
                        </li>
                        <li className="nav-item">
                            <Link to={"/addproduct"} className="nav-link">
                                Add Product
                            </Link>
                        </li>
                        <li className="nav-item">
                            <Link to={"/addseller"} className="nav-link">
                                Add Seller
                            </Link>
                        </li>
                    </div>
                </nav>

                <div className="container mt-3">
                    <Routes>
                        <Route exact path="/products" element={<ProductList />} />
                        <Route exact path="/addproduct" element={<AddProduct />} />
                        <Route path="/addseller" element={<AddSeller />} />
                    </Routes>
                </div>
        </div>
        )
    }
}

export default App;