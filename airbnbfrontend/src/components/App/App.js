import React, {Component} from 'react';
import './App.css';
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import AirbnbService from "../../repository/service";
import Accomodation from "../Accommodation/accomodation";
import CategoryList from "../Categories/CategoryList";
import AddAccommodation from "../Accommodation/addAccommodation";
import EditAccommodation from "../Accommodation/editAccommodation";
import Header from "../Header/header";
import AccommodationPageable from "../Accommodation/accommodationPageable";
import Host from "../Host/host";




class App extends Component {

// axios.get('/accommodations').then(x => {
//   console.log(x.data)
// })


    constructor(props){
        super(props);
        this.state = {
            accommodations: [],
            hosts: [],
            countries: [],
            categories: [],
            selectedAccommodation: {}
        }
    }

    render(){
        console.log(this.state.accommodations);
        console.log(this.state.categories);
        console.log("nad selected")
        console.log(this.state.selectedAccommodation)


        return(
            <Router>
                <Header/>
                <main>
                    <div className="container">
                        <Routes>
                            <Route path={"/accommodations"} element={<Accomodation
                                accommodations={this.state.accommodations}
                                onEdit={this.getAccommodation}
                                onDelete={this.deleteAccommodation}
                                onRent={this.rentAccommodation}
                            />}/>

                            <Route path={"/accommodationsPageable"} element={<AccommodationPageable
                                accommodations={this.state.accommodations}
                                onEdit={this.getAccommodation}
                                onDelete={this.deleteAccommodation}
                                onRent={this.rentAccommodation}
                            />}/>

                            <Route path={"/categories"} element={<CategoryList cats={this.state.categories}/>}/>
                            <Route path={"/addAccommodation"} element={<AddAccommodation
                                hosts={this.state.hosts}
                                cats={this.state.categories}
                                addAcc={this.addAccommodation}
                            />}/>

                            <Route path={"/editAccommodation/:id"} element={<EditAccommodation
                                selected={this.state.selectedAccommodation}
                                hosts={this.state.hosts}
                                cats={this.state.categories}
                                onEdit={this.editAccommodation}/>} />

                            <Route path={"/hosts"} element={<Host hosts={this.state.hosts}/>}/>

                        </Routes>
                    </div>
                </main>
            </Router>
        );

    }



    componentDidMount() {
        this.fetchData();
    }

    fetchData = () => {
        this.loadAccomodations();
        this.loadHosts();
        this.loadCountries();
        this.loadCategories();
    }

    loadAccomodations = () => {
        console.log("load")
        AirbnbService.fetchAccomodations()
            .then((data) => {
                this.setState({
                    accommodations: data.data
                })
            })
    }

    loadHosts = () => {
        AirbnbService.fetchHosts()
            .then((data) => {
                this.setState({
                    hosts: data.data
                })
            })
    }

    loadCountries = () => {
        AirbnbService.fetchCountries()
            .then((data) => {
                this.setState({
                    countries: data.data
                })
            })
    }

    loadCategories = () => {
        console.log("load cats")
        AirbnbService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            })
    }

    addAccommodation = (name, category, hostId, numRooms) => {
        AirbnbService.addAccommodation(name, category, hostId, numRooms)
            .then(() => {
                this.loadAccomodations();
            })
    }

    editAccommodation = (id, name, category, hostId, numRooms) => {
        console.log("vlaga li tuka")
        console.log(id, name, category, hostId, numRooms);
        AirbnbService.editAccommodation(id, name, category, hostId, numRooms)
            .then(() => {
                this.loadAccomodations();
            })
    }

    getAccommodation = (id) => {
        console.log("Vo getot")
        AirbnbService.getAccommodation(id)
            .then((data) => {
                this.setState({
                    selectedAccommodation : data.data
                })
            })
    }

    deleteAccommodation = (id) => {
        console.log("brisam")
        AirbnbService.deleteAccommodation(id)
            .then(() => {
                this.loadAccomodations()
            })
    }


    rentAccommodation = (id) => {
        AirbnbService.rentAccommodation(id)
            .then(() => {
                this.loadAccomodations()
            })
    }

}
export default App;
