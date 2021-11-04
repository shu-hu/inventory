import ProductService from "../services/productService";
import { useEffect, useState } from 'react';
import { Link, useHistory } from 'react-router-dom';

const ProductList = () => {

    const [products, setProducts] = useState([]);

    const init = () => {
        console.log('init')
        ProductService.getAll()
            .then(response => {
                console.log('Printing products data', response.data);
                setProducts(response.data);
            })
            .catch(error => {
                console.log('Something went wrong', error);
            })
    }

    useEffect(() => {
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
                <table className="table table-bordered table-striped">
                    <thead className="thead-dark">
                        <tr>
                            <th>Name</th>
                            <th>SKU</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            products.map(product => (
                                <tr key={product.id}>
                                    <td>{product.name}</td>
                                    <td>{product.sku}</td>
                                    <td>
                                        <Link className="btn btn-info" to={`/product/edit/${product.id}`}>Update</Link>

                                        <button className="btn btn-danger ml-2" onClick={() => {
                                            handleDelete(product.id);
                                        }}>Delete</button>
                                    </td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>

            </div>
        </div>
    );
}

export default ProductList;