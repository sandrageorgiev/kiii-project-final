import React from 'react';
import Item from "./item";
import {Link} from "react-router-dom";

const accomodation = (props) => {
    console.log(props)
    console.log(props.accommodations);

    // const filteredAccommodations = props.accommodations.filter(acc => acc.numRooms === 3 && acc.host.country.name === "Croatia" && acc.category && acc.category === "FLAT");


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
                                <th scope={"col"}>Number Of Rooms</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                        {props.accommodations.filter(acc => acc.numRooms >= 3 && acc.host.country.name === "Croatia" && acc.category && acc.category === "FLAT")
                            .map((acc) => {
                            console.log("item")
                                return (

                                        <Item item={acc} onEdit={props.onEdit} onDelete={props.onDelete}
                                              onRent={props.onRent}/>

                                );

                        })}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}

export default accomodation;