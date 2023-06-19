import axios from "axios";

export default axios.create({
    baseURL: 'https://aribackend.pro:8081'
})