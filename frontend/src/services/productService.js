import http from "../http-common";

const getAll = () => {
    return http.get('/products');
}

const create = data => {
    return http.post("/product", data);
}

const get = id => {
    return http.get(`/product/${id}`);
}

const update = data => {
    return http.put('/product', data);
}

const remove = id => {
    return http.delete(`/product/${id}`);
}
export default { getAll, create, get, update, remove };