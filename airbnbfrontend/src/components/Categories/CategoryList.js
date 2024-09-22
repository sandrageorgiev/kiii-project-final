import React from "react";

const categoryList = (props) => {
    console.log(props.cats)
    return (
        <div className="container">
            <h1>CATEGORIES</h1>
            <ul>
                {props.cats.map((cat) => {
                    return(
                        <li>{cat}</li>
                    )
                })}
            </ul>
        </div>

    );
}

export default categoryList;