import React, { useEffect, useState } from "react";
import { Button, CssBaseline, TextField, Link, Grid, Typography, makeStyles, Container} from '@material-ui/core';
import Axios from 'axios';
import Usa from "@svg-maps/usa";
import { SVGMap } from "react-svg-map";
import "react-svg-map/lib/index.css";
import axios from "axios";
import MUIDataTable from "mui-datatables";
import MenuItem from '@material-ui/core/MenuItem';
import Select from '@material-ui/core/Select';
import states from "./states.json"
export default function Home() {

    const BASE_URL = "http://localhost:8080/api/"


    var stateNames={}
    states.map((index_value)=>{
        
        stateNames[index_value.abbreviation.toLowerCase()]=index_value.name
    })

    const [state_name, setstate] = useState([])

    const [vaccine_name,setvaccine] = useState('')

    const [date,setdate] = useState()

    const [result1,setComplex1] = useState([])

    const [result2,setComplex2] = useState([])

    const [result3,setComplex3] = useState([])

    const [result4,setComplex4] = useState([])

    const [result5,setComplex5] = useState([])

    const [result6,setSimple1] = useState([])

    const [result7,setSimple2] = useState([[]])

    const [result8,setSimple3] = useState([[]])

    useEffect(() => {
        getHighestStock()
        getCounty()
        simpleQuery1()
        simpleQuery2()
        return () => {
           
        }
    }, [])

    useEffect(() => {
        simpleQuery3(state_name)
        return () => {
    
        }
    }, [state_name])

    useEffect(() => {
        getTotalPeople(vaccine_name)
        getUserNamesSideEffects(vaccine_name)
        return () => {
           
        }
    }, [vaccine_name])

    useEffect(() => {
        getUserNames(date)
        return () => {
            
        }
    }, [date])

    const columns_complex1=["State"]
    const columns_complex2=["Total people"]
    const columns_complex3=["name"]
    const columns_complex4=["County"]
    const columns_complex5=["name"]
    const columns_simple1=["state"]
    const columns_simple2=["county","state"]
    const columns_simple3=["county","state"]




    const handleOnChange=(event)=>{
        const location=event.target;
        setstate(stateNames[location["id"]])
        
      }

    const handleVaccine=(event)=>{
        setvaccine(event.target.innerText);
        
        
    }

    const handleDate=(event)=>{
        setdate(event.target.innerText)
       
        
    }

    const getHighestStock=()=>{
        axios.get(BASE_URL + `/complex_query1`)
        .then(res=>{
        setComplex1(res.data)
            }).catch(err=>{
            console.log(err)
        })
    }
    const getTotalPeople=()=>{
        
        axios.get(BASE_URL + `/complex_query2/`+vaccine_name)

        .then(res=>{
        setComplex2(res.data)
            }).catch(err=>{
            console.log(err)
        })
    }
    const getUserNames=()=>{
        axios.get(BASE_URL + `/complex_query3/`+date)
        .then(res=>{
        setComplex3(res.data)
            }).catch(err=>{
            console.log(err)
        })
    }
    const getCounty=()=>{
        axios.get(BASE_URL + `/complex_query4`)
        .then(res=>{
        setComplex4(res.data)
            }).catch(err=>{
            console.log(err)
        })
    }
    const getUserNamesSideEffects=()=>{
        axios.get(BASE_URL + `/complex_query5/`+vaccine_name)
        .then(res=>{
        setComplex5(res.data)
            }).catch(err=>{
            console.log(err)
        })
    }
    const simpleQuery1=()=>{
        axios.get(BASE_URL + `/simple_query1`)
        .then(res=>{
        setSimple1(res.data)
            }).catch(err=>{
            console.log(err)
        })
    }
    const simpleQuery2=()=>{
        axios.get(BASE_URL + `/simple_query2`)
        .then(res=>{
        var data=[[]]
        res.data.map((index)=>{
            data.push([index["county"],index["state"]])
        })
        
        setSimple2(data)
        console.log(result7)
            }).catch(err=>{
            console.log(err)
        })
    }
    const simpleQuery3=()=>{
        axios.get(BASE_URL + `/simple_query3/`+state_name)
        .then(res=>{
            var data=[[]]
            res.data.map((index)=>{
                data.push([index["county"],index["state"]])
            })
        setSimple3(data)
            }).catch(err=>{
            console.log(err)
        })
    }


const options = {
    filterType: 'checkbox',
  };
  

    return (
        <div>
      <br></br>
       
        <Grid container item xs={12} spacing={3}>
        
        <Container maxWidth="xs" display="inline-block">
          <p>select a state</p>
             <SVGMap map={Usa} onLocationClick={(event)=>handleOnChange(event)}/>
        
        </Container>
        <Container maxWidth="xs" display="inline-block">
        <p>select a Vaccine</p>
        <Select
          labelId="demo-controlled-open-select-label"
          id="demo-controlled-open-select"
        >
          <MenuItem value="">
            <em>Vaccine</em>
          </MenuItem>
          <MenuItem value={"Pfizer"} onClick={handleVaccine}>Pfizer</MenuItem>
          <MenuItem value={"Moderna"} onClick={handleVaccine}>Moderna</MenuItem>
          <MenuItem value={"JJ"} onClick={handleVaccine}>JJ</MenuItem>
        </Select>
        </Container>
        <Container maxWidth="xs" display="inline-block">
        <p>select a month</p>
        <Select
          labelId="demo-controlled-open-select-label"
          id="demo-controlled-open-select"
        >
          <MenuItem value="">
            <em>Month</em>
          </MenuItem>
          <MenuItem value={1} onClick={handleDate}>01</MenuItem>
          <MenuItem value={2} onClick={handleDate}>02</MenuItem>
          <MenuItem value={3} onClick={handleDate}>03</MenuItem>
          <MenuItem value={4} onClick={handleDate}>04</MenuItem>
          <MenuItem value={5} onClick={handleDate}>05</MenuItem>
          <MenuItem value={6} onClick={handleDate}>06</MenuItem>
          <MenuItem value={7} onClick={handleDate}>07</MenuItem>
          <MenuItem value={8} onClick={handleDate}>08</MenuItem>
          <MenuItem value={9} onClick={handleDate}>09</MenuItem>
          <MenuItem value={10} onClick={handleDate}>10</MenuItem>
          <MenuItem value={11} onClick={handleDate}>11</MenuItem>
          <MenuItem value={12} onClick={handleDate}>12</MenuItem>
        </Select>
        </Container>
        </Grid>
        
        <br></br>
        <br></br>


        
        <Grid container spacing={3}>
        <Grid item xs={2.5}>
        <Container maxWidth="xs" display="inline-block">
   
        <MUIDataTable
            title={"highest stock of Pfizer"}
            data={[result1]}
            columns={columns_complex1}
            options={options}
        />
        </Container>
        </Grid>
        <Grid item xs={2.5}>
        <Container maxWidth="xs" display ="inline-block">
       
        <MUIDataTable
            title={"Total people in Illinois vaccinated by a particular vaccine"}
            data={[result2]}
            columns={columns_complex2}
            options={options}
        />
        </Container>
        </Grid>
        <Grid item xs={2.5}>
        <Container maxWidth="xs" display ="inline-block">
        <MUIDataTable
            title={"users who have received both doses in the given month"}
            data={[result3]}
            columns={columns_complex3}
            options={options}
        />
        </Container>
        </Grid>
        <Grid item xs={2.5}>
        <Container maxWidth="xs" display ="inline-block">
        <MUIDataTable
            title={"County where people have had the maximum side effects after taking vaccine"}
            data={[result4]}
            columns={columns_complex4}
            options={options}
        />
        </Container>
        </Grid>
        <Grid item xs={2.5}>
        <Container maxWidth="xs" display ="inline-block">
        <MUIDataTable
            title={"Names of receivers who have had body pain greater than the average duration of all other people who have had body pain after taking Pfizer"}
            data={[result5]}
            columns={columns_complex5}
            options={options}
        />
        </Container>
        </Grid>
        <Grid item xs={2.5}>
        <Container maxWidth="xs" display ="inline-block">
        <MUIDataTable
            title={"State which received the highest vaccination till date"}
            data={[[result6]]}
            columns={columns_simple1}
            options={options}
        />
        </Container>
        </Grid>
        <Grid item xs={2.5}>
        <Container maxWidth="xs" display ="inline-block">
        <MUIDataTable
            title={"counties which have vaccination rate less than 50%"}
            data={result7}
            columns={columns_simple2}
            options={options}
        />
        </Container>
        </Grid>
        <Grid item xs={2.5}>
        <Container maxWidth="xs" display ="inline-block">
        <MUIDataTable
            title={"county which has the highest vaccination centres."}
            data={result8}
            columns={columns_simple3}
            options={options}
        />
        </Container>
        </Grid>
        </Grid>
       
        </div>
    )
};