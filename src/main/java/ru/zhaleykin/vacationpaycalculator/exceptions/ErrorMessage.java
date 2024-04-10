package ru.zhaleykin.vacationpaycalculator.exceptions;

import java.util.Objects;

public class ErrorMessage {
    private final int status;
    private final String message;

    ErrorMessage(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ErrorMessage) obj;
        return this.status == that.status &&
                Objects.equals(this.message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message);
    }

    @Override
    public String toString() {
        return "ErrorMessage[" +
                "status=" + status + ", " +
                "message=" + message + ']';
    }
}