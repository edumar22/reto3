package com.example.proyectomictic.entities;



import java.io.Serializable;
//@Data
//@AllArgsConstructor

//@NoArgsConstructor
public class ReportClient implements Serializable {
        public int total;
        public Client client;

        public int getTotal () {
            return total;
        }

        public void setTotal ( int total){
            this.total = total;
        }

        public Client getClient () {
            return client;
        }

        public void setClient (Client client){
            this.client = client;
        }
    }


