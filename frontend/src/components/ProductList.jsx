import ProductService from "../services/productService";
import SellerProductService from "../services/sellerProductService";
import { useEffect, useState } from 'react';
import { Link, useHistory } from 'react-router-dom';

const ProductList = () => {

    const [products, setProducts] = useState([]);
    const [sellerProducts, setSellerProducts] = useState([]);

    const init = () => {
        ProductService.getAll()
            .then(response => {
                console.log('Printing products data', response.data);
                setProducts(response.data);
            })
            .catch(error => {
                console.log('Something went wrong', error);
            })
        
        SellerProductService.getAll()
            .then(response => {
                console.log('Printing sellerProduct data', response.data);
                setSellerProducts(response.data);
            })
            .catch(error => {
                console.log('Something went wrong', error);
            })
    }

    useEffect(async () => {
        init();
    }, []);

    const handleDelete = (id) => {
        console.log('Printing id', id);
        ProductService.remove(id)
            .then(response => {
                console.log('product deleted successfully', response.data);
                init();
            })
            .catch(error => {
                console.log('Something went wrong', error);
            })
    }

    return (
        <div className="container">
            <h3>List of Products</h3>
            <hr />
            <div>
                <Link to="/addproduct" className="btn btn-primary mb-2">Add Product</Link>
                <div>
                    {products.map(product => (
                        <div class="card" key="product.id">
                            <ul>
                                <li>Produt Name: {product.name}</li>
                                <li>Produt SKU: {product.sku}</li>
                                <li>Create Date: {product.createdate}</li>
                                <li>Sellers:
                                    {sellerProducts.filter(sp => sp.product.id == product.id).sort((a, b) => a.price - b.price).map(
                                        sp => (
                                            <div>{sp.seller.name}
                                                <ul>
                                                    <li>Price: $ {sp.price}</li>
                                                    <li>Inventory Amount: {sp.inventoryAmount}</li>
                                                </ul>
                                            </div>
                                        )
                                    )}
                                </li>
                            </ul>

                            <button className="btn btn-danger ml-2" onClick={() => {
                                handleDelete(product.id);
                            }}>Delete</button>
                        </div>
                    ))}
                    
                </div>

            </div>
        </div>
    );
}

export default ProductList;