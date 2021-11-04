
import { Link, useNavigate, useParams } from "react-router-dom";
import productService from "../services/productService";
import sellerProductService from "../services/sellerProductService";
import sellerService from "../services/sellerService";
import { useEffect, useState } from 'react';

const AddProduct = () => {
    const [name, setName] = useState('');
    const [sku, setSku] = useState('');
    const [date, setDate] = useState('');
    const [sellers, setSellers] =  useState([]);
    const [price, setPrice] = useState('');
    const [inventoryAmount, setInventoryAmount] = useState('');
    const navigate = useNavigate();
    const { id } = useParams();

    const [choosedSeller, setChoosedSeller] = useState([]);

    const init = () => {
        sellerService.getAll()
            .then(response => {
                console.log('Printing sellers data', response.data);
                setSellers(response.data);
            })
            .catch(error => {
                console.log('Something went wrong', error);
            })
    }

    useEffect(async () => {
        init();
    }, []);

    const saveProduct = (e) => {
        e.preventDefault();

        const product = { name, sku, date};
        const sellerProduct = { price, inventoryAmount}
        console.log("choodes:" ,choosedSeller);
        if (id) {
            //update
            productService.update(product)
                .then(response => {
                    console.log('Product data updated successfully', response.data);
                    navigate('/products');
                })
                .catch(error => {
                    console.log('Something went wrong', error);
                })
        } else {
            //create
            productService.create(product)
                .then(response => {
                    console.log("product added successfully", response.data);
                    sellerProduct.product = response.data;
                    sellerProduct.seller = sellers.find(s => s.name == choosedSeller);
                    sellerProductService.create(sellerProduct)
                        .then(res => {
                            console.log('!!!!sellerproduct', res.data)
                        })
                        .catch(error => {
                            console.log('Something went wrong', error);
                        })
                    navigate("/products");
                })
                .catch(error => {
                    console.log('something went wroing', error);
                })
        }
    }

    useEffect(() => {
        if (id) {
            productService.get(id)
                .then(product => {
                    setName(product.data.name);
                    setSku(product.data.sku);
                    setDate(product.data.createdate);
                })
                .catch(error => {
                    console.log('Something went wrong', error);
                })
        }
    }, [])
    return (
        <div className="container">
            <h3>Add product</h3>
            <hr />
            <form >
                <div className="form-group">
                    <input
                        type="text"
                        className="form-control col-4"
                        id="name"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                        placeholder="Product Name"
                    />

                </div>
                <div className="form-group">
                    <input
                        type="text"
                        className="form-control col-4"
                        id="sku"
                        value={sku}
                        onChange={(e) => setSku(e.target.value)}
                        placeholder="Product SKU"
                    />

                </div>
                <div>
                    Seller:  
                    <select value={choosedSeller.name}
                    onChange={(e) => setChoosedSeller(e.target.value)}>
                        {sellers.map(seller => (
                            <option name={seller.name}> {seller.name}</option>
                        ))}
                    </select>
                </div>
                <div className="form-group">
                    <input
                        type="text"
                        className="form-control col-4"
                        id="price"
                        value={price}
                        onChange={(e) => setPrice(e.target.value)}
                        placeholder="Price"
                    />
                </div>

                <div className="form-group">
                    <input
                        type="text"
                        className="form-control col-4"
                        id="inventoryAmount"
                        value={inventoryAmount}
                        onChange={(e) => setInventoryAmount(e.target.value)}
                        placeholder="Inventory Amount"
                    />
                </div>
                <div >
                    <button onClick={(e) => saveProduct(e)} className="btn btn-primary">Save</button>
                </div>
            </form>
            <hr />
            <Link to="/products">Back to List</Link>
        </div>
    )
}

export default AddProduct;