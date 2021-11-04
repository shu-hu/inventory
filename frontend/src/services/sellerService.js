import http from "../http-common";

const getAll = () => {
    return http.get('/sellers');
}


export default { getAll};