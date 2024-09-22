import React from "react";
import {useNavigate} from "react-router-dom";

const EditAccommodation = (props) => {

    console.log("prikazi selected")
    console.log(props.selected)
    // console.log(props.selected.host.id)

    const navigate = useNavigate();

    const[formData, updateFormData] = React.useState({
        name: "",
        category:"HOTEL",
        hostId: 1,
        numRooms: 0
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name] : e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name !== "" ? formData.name : (props.selected ? props.selected.name : '');
            // formData.name !== "" ? formData.name : props.selected.name;
        const category = formData.category !== "HOTEL" ? formData.category : props.selected.category;
        const hostId = formData.hostId !== 1 ? formData.hostId : props.selected.host.id;
        const numRooms = formData.numRooms !== 0 ? formData.numRooms : props.selected.numRooms;

        props.onEdit(props.selected.id, name, category, hostId, numRooms);
        navigate('/accommodations')
    }

    return(
        <div className="row">
            <div className="col-6">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group m-5">
                        <label htmlFor="name">Accommodation name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               placeholder={props.selected.name}
                               onChange={handleChange}
                        />
                    </div>


                    <div className="form-group m-5">
                        <label htmlFor="category">Category</label>
                        <select name="category" className="form-control" onChange={handleChange}>
                            {props.cats.map((cat) => {
                                if (props.selected.category !== undefined && props.selected.category === cat)
                                    return <option selected={props.selected.category} value={cat}>{cat}</option>
                                else return <option value={cat}>{cat}</option>
                            })}

                            </select>
                    </div>

                    <div className="form-group m-5">
                        <label htmlFor="hostId">Host</label>
                        <select name="hostId" className="form-control" onChange={handleChange}>

                            {props.hosts && props.hosts.map((host) => {
                                if (props.selected && props.selected.host && props.selected.host.id && props.selected.host.id === host.id)
                                    return <option selected={props.selected.host.id} value={host.id}>{host.name} {host.surname}</option>
                                else return <option value={host.id}>{host.name} {host.surname}</option>
                            })}

                        </select>
                    </div>


                    <div className="form-group m-5">
                        <label htmlFor="numRooms">Number Of Rooms</label>
                        <input type="number"
                               className="form-control"
                               id="numRooms"
                               name="numRooms"
                               placeholder={props.selected.numRooms}
                               onChange={handleChange}
                        />
                    </div>

                    <button type="submit" className="btn btn-primary m-5">Submit</button>
                </form>


            </div>
        </div>
    )


}

export default EditAccommodation;