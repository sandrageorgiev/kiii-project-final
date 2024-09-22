import React from 'react'
import {useNavigate} from "react-router-dom";

const AddAccommodation  = (props) => {

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
        const name = formData.name;
        const category = formData.category;
        const hostId = formData.hostId;
        const numRooms = formData.numRooms;

        props.addAcc(name, category, hostId, numRooms);
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
                               required
                               placeholder="Enter name"
                               onChange={handleChange}
                        />
                    </div>


                    <div className="form-group m-5">
                        <label htmlFor="category">Category</label>
                        <select name="category" className="form-control" onChange={handleChange}>
                            <option value="">Select category</option>
                            {props.cats.map((cat, index) => {
                                return (
                                    <option key={index} value={cat}>{cat}</option>
                                )
                            })}
                        </select>
                    </div>

                    <div className="form-group m-5">
                        <label htmlFor="host">Host</label>
                        <select name="hostId" className="form-control" onChange={handleChange}>
                            <option>Select host</option>
                            {props.hosts.map((host, index) => {
                                return (
                                    <option key={index} value={host.id}>{host.name} {host.surname}</option>
                                )
                            })}
                        </select>
                    </div>


                    <div className="form-group m-5">
                        <label htmlFor="numRooms">Number Of Rooms</label>
                        <input type="number"
                               className="form-control"
                               id="numRooms"
                               name="numRooms"
                               required
                               placeholder="Enter number of rooms"
                               onChange={handleChange}
                        />
                    </div>

                    <button type="submit" className="btn btn-primary m-5">Submit</button>
                </form>


            </div>
        </div>
    )


}

export default AddAccommodation;

