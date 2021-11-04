import http from "../http-common";

const getAll = () => {
    return http.get('/sellerproducts');
}


const get= (id) => {
    return http.get(`/sellerproduct?product_id=${id}`);
}

const create = data => {
    return http.post("/sellerproduct", data);
}

export default { getAll, get, create};