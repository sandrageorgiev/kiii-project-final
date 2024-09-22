import React from 'react'


const Host = (props) => {

    return(


        <div>
            <div>
                <div>
                    <h1>FILTERED HOSTS</h1>
                    <table className="table table-hover">
                        <thead>
                        <tr>
                            <th scope={"col"}>Name</th>
                            <th scope={"col"}>Surname</th>

                        </tr>
                        </thead>
                        <tbody>
                        {props.hosts.filter(host => host.country.name === "Croatia")
                            .map((host) => {
                                console.log("host item")
                                return (
                                    <tr>
                                        <td>{host.name}</td>
                                        <td>{host.surname}</td>
                                    </tr>


                                );

                            })}
                        </tbody>
                    </table>
                </div>
            </div>


            <div className="mt-5">
                <div>
                    <h1>ALL HOSTS</h1>
                    <table className="table table-hover">
                        <thead>
                        <tr>
                            <th scope={"col"}>Name</th>
                            <th scope={"col"}>Surname</th>

                        </tr>
                        </thead>
                        <tbody>
                        {props.hosts.map((host) => {
                                console.log("host item")
                                return (
                                    <tr>
                                        <td>{host.name}</td>
                                        <td>{host.surname}</td>
                                    </tr>


                                );

                            })}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );

}

export default Host;