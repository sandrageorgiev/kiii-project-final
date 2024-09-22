import React from 'react'
import {Link} from 'react-router-dom'
import Item from "./item";
import ReactPaginate from "react-paginate";

class AccommodationPageable extends React.Component {


    constructor(props) {
        super(props);
        this.state = {
            page: 0,
            size: 5
        }
    }





    render(){

        const accommodationsFiltered = this.props.accommodations.filter(acc => acc.numRooms > 0);

        const pageCount = Math.ceil(accommodationsFiltered.length / this.state.size);
        const offset = this.state.size * this.state.page;
        const nextPageOffset = offset + this.state.size;
        const accs = this.getAccommodationsPage(offset, nextPageOffset);

        return(


            <div>
                <div>
                    <div>
                        <Link to={"/addAccommodation"}>Add new Accommodation</Link>

                        <table className="table table-hover">
                            <thead>
                            <tr>
                                <th scope={"col"}>Name</th>
                                <th scope={"col"}>Category</th>
                                <th scope={"col"}>Host</th>
                                <th scope={"col"}>Number Of Free Rooms</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            {accs}
                            </tbody>
                        </table>
                    </div>

                    <ReactPaginate previousLabel={"back"}
                                   nextLabel={"next"}
                                   breakLabel={<a href="/#">...</a>}
                                   breakClassName={"break-me"}
                                   pageClassName={"ml-1"}
                                   pageCount={pageCount}
                                   marginPagesDisplayed={5}
                                   pageRangeDisplayed={2}
                                   onPageChange={this.handlePageClick}
                                   containerClassName={"pagination m-4 justify-content-center"}
                                   activeClassName={"active"}/>

                </div>
            </div>
        );
    }


    handlePageClick = (data) => {
        let selected = data.selected;
        this.setState(({
            page: selected
        }))
    }

    getAccommodationsPage = (offset, nextPageOffset) =>{

        const accommodationsFiltered = this.props.accommodations.filter(acc => acc.numRooms > 0);

        return accommodationsFiltered.map((acc) => {
            console.log("item")
            return (

                <Item item={acc} onEdit={this.props.onEdit} onDelete={this.props.onDelete}
                      onRent={this.props.onRent}/>

            );

        }).filter((accommodation, index) => {
            return  index >= offset && index < nextPageOffset;
        })
    }


}

export default AccommodationPageable;