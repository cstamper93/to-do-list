import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:9000'
});

export default {
    fetchAllListItems() {
        return http.get("/item");
    },
    addListItem(item) {
        return http.post("/item", item);
    },
    editListItem(item) {
        return http.put("/item", item);
    },
    deleteListItem(id) {
        return http.delete(`/item/${id}`);
    }
}