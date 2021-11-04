// import { useState } from "react";
// import { Link, useHistory, useParams } from "react-router-dom";
// import { useEffect } from "react/cjs/react.development";
// import productService from "../services/productService";
// import sellerProductService from "../services/sellerProductService";

// const AddProduct = () => {
//     const [name, setName] = useState('');
//     const [sku, setSku] = useState('');
//     const [date, setDate] = useState('');
//     const [seller, setSeller] =  useState([]);
//     const [price, setPrice] = useState('');
//     const [quantity, setQuantity] = useState('');
//     const history = useHistory();
//     const { id } = useParams();

//     const saveProduct = (e) => {
//         e.preventDefault();

//         const product = { name, location, seller, price, quantity };
//         if (id) {
//             //update
//             productService.update(product)
//                 .then(response => {
//                     console.log('Product data updated successfully', response.data);
//                     history.push('/');
//                 })
//                 .catch(error => {
//                     console.log('Something went wrong', error);
//                 })
//         } else {
//             //create
//             productService.create(product)
//                 .then(response => {
//                     console.log("product added successfully", response.data);
//                     history.push("/");
//                 })
//                 .catch(error => {
//                     console.log('something went wroing', error);
//                 })
//         }
//     }

//     useEffect(() => {
//         if (id) {
//             productService.get(id)
//                 .then(product => {
//                     setName(product.data.product.name);
//                     setSku(product.data.product.sku);
//                     setDate(product.data.product.createdate);
//                     setSeller(product.data.seller.name);
//                     setPrice(product.data.price);
//                     setQuantity(product.data.inventoryAmount);
//                 })
//                 .catch(error => {
//                     console.log('Something went wrong', error);
//                 })
//         }
//     }, [])
//     return (
//         <div className="container">
//             <h3>Add product</h3>
//             <hr />
//             <form>
//                 <div className="form-group">
//                     <input
//                         type="text"
//                         className="form-control col-4"
//                         id="name"
//                         value={name}
//                         onChange={(e) => setName(e.target.value)}
//                         placeholder="Product Name"
//                     />

//                 </div>
//                 <div className="form-group">
//                     <input
//                         type="text"
//                         className="form-control col-4"
//                         id="sku"
//                         value={sku}
//                         onChange={(e) => setSku(e.target.value)}
//                         placeholder="Product SKU"
//                     />

//                 </div>
//                 <div className="form-group">
//                     <input
//                         type="time"
//                         className="form-control col-4"
//                         id="date"
//                         value={date}
//                         onChange={(e) => setDate(e.target.value)}
//                     />
//                 </div>
//                 <div >
//                     <button onClick={(e) => saveproduct(e)} className="btn btn-primary">Save</button>
//                 </div>
//             </form>
//             <hr />
//             <Link to="/">Back to List</Link>
//         </div>
//     )
// }

// export default Addproduct;