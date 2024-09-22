import axios from "../custom-axios/axios";

const AirbnbService = {
    fetchAccomodations: () => {
        return axios.get("/accommodations")
    },

    fetchHosts: () => {
        return axios.get("/host")
    },

    fetchCountries: () => {
        return axios.get("/country")
    },

    fetchCategories: () => {
        return axios.get("/accommodations/categories")
    },

    addAccommodation: (name, category, hostId, numRooms) => {
        debugger;
        return axios.post("/accommodations/addAccommodation", {
            "name" : name,
            "category" : category,
            "hostId" : hostId,
            "numRooms" : numRooms
        });
    },

    editAccommodation: (id, name, category, hostId, numRooms) => {
        return axios.post(`/accommodations/edit/${id}`, {
            "name" : name,
            "category" : category,
            "hostId" : hostId,
            "numRooms" : numRooms
        });
    },

    getAccommodation: (id) => {
        return axios.get(`/accommodations/${id}`);
    },

    deleteAccommodation: (id) =>{
        return axios.post(`/accommodations/delete/${id}`)
    },

    rentAccommodation: (id) => {
        return axios.post(`/accommodations/rent/${id}`)
    }

}

export default AirbnbService;