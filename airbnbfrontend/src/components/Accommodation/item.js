
import React from "react";
import {Link} from 'react-router-dom'

const item = (props) => {
    console.log('vo item')
    console.log(props)
    return (

        <tr>
            <td>{props.item.name}</td>
            <td>{props.item.category}</td>
            <td>{props.item.host.name + ' ' + props.item.host.surname}
            </td>
            <td>{props.item.numRooms}</td>
            <td>
                <Link className="btn btn-info m-2"
                    onClick={() => props.onEdit(props.item.id)}
                    to={`/editAccommodation/${props.item.id}`}>
                    Edit
                </Link>

                <Link className="btn btn-danger m-2"
                      onClick={() => props.onDelete(props.item.id)}
                      to={"/accommodationsPageable"}>
                    Delete
                </Link>

                <Link className="btn btn-warning m-2"
                      onClick={() => props.onRent(props.item.id)}
                      to={"/accommodationsPageable"}>
                    Rent
                </Link>

                {/*<a title={"Delete"}
                    className="btn btn-danger"
                    onClick={() => props.onDelete(props.item.id)}>
                    Delete
                </a>*/}
            </td>
        </tr>
    )
}

export default item;