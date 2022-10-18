package com.example.proyectomictic.entities;

import java.io.Serializable;

public class Status implements Serializable {
    public int completed;
    public int cancelled;

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
}


