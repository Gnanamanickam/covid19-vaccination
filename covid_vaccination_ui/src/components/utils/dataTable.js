import React, {useEffect, useState} from "react";
import MUIDataTable from "mui-datatables";
import axios from 'axios';
import { Container } from "@material-ui/core";

export default function DataTable() {
    const [posts, setPost] = useState([]);
    let signal = axios.CancelToken.source();
    let BASE_URL = 'http://localhost:8080/api/';
    const handleInputChange = (event) => {
        setPost((prevProps) => ({
          ...prevProps,
          [event.target.name]: event.target.value
        }));
      };

      function handleSubmit(event,id) {
        event.preventDefault();
        console.log(id)
        axios.delete(BASE_URL + `/receiver/${id}`)
          .then(res => {
            console.log(res);
            console.log(res.data);
            const posts = this.state.posts.filter(item => item.id !== id);
            setPost(posts);
          })    
      };

    useEffect(() => {
        let isSubscribed = true;
        axios.get(BASE_URL + `/receiver`, {
            cancelToken: signal.token,
        })
            .then(res => {
                const posts = res.data;
                setPost(posts);
            }).catch(err => {
            console.log(err);
        });
        return function cleanup() {
            isSubscribed = false;
            signal.cancel('Api is being canceled');
        }
    }, []);

    const columns = ["id", "user_id", "vaccine_id", "center_id"];

    const options = {
        filter: true,
        filterType: "dropdown",
        print: false,
        viewColumns: true,
        selectableRows: 'none',
        onRowClick: (rowData) => {
            console.log("RowClicked->", rowData);
        },
        responsive: "stacked",
        fixedHeaderOptions: {
            xAxis: false,
            yAxis: true,
        },
    };
    

    return (
        <Container>
        <MUIDataTable
            title={"Posts"}
            data={posts}
            columns={columns}
            options={options}
        />
        </Container>
    );
}



