import React from 'react'
import Usa from "@svg-maps/usa";
import { SVGMap } from "react-svg-map";
import "react-svg-map/lib/index.css";
export default function DisplayResults() {
    var stateNames={}
    stateNames['al']="Alabama"
    stateNames['ak']="Alaska"
    stateNames['az']="Arizona"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"
    stateNames['al']="Alabama"


    const handleOnChange=(event)=>{
        const location=event.target;
        console.log(location.name)
      }

   
    return (
        <div class="center" style={{ width:'300px', height:'300px'}}>
             <SVGMap map={Usa} onLocationClick={(event)=>handleOnChange(event)}/>
        </div>
    )
}
