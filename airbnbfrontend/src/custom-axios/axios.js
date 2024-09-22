import axios from "axios";

const instance = axios.create({
    baseURL: 'http://backend.com/api',
    headers: {
        'Access-Control-Allow-Origin' : '*',
    }``
})

export default instance;