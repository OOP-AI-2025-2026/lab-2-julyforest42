package ua.opnu;


public class TimeSpan {

    private int hours;
    private int minutes;

    TimeSpan(int hours, int minutes) {
        this.hours = (hours >= 0 ? hours : 0);
        this.minutes = (minutes >= 0 && minutes < 60 ? minutes : 0);
    }

    int getHours() {
        return hours;
    }

    int getMinutes() {
        return minutes;
    }

    void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) return;
        this.hours += hours + (this.minutes + minutes >= 60 ? 1 : 0);
        this.minutes = (this.minutes + minutes) % 60;
    }

    void addTimeSpan(TimeSpan timespan) {
        int hours = timespan.getHours();
        int minutes = timespan.getMinutes();
        this.hours += hours + (this.minutes + minutes >= 60 ? 1 : 0);
        this.minutes = (this.minutes + minutes) % 60;
    }

    double getTotalHours() {
        return hours + (minutes / 60.0);
    }

    int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    void subtract(TimeSpan span) {
        int hours = span.getHours();
        int minutes = span.getMinutes();
        if (hours*60 + minutes > this.hours*60 + this.minutes) return;
        this.hours -= hours + (minutes > this.minutes ? 1 : 0);
        this.minutes = (this.minutes - minutes < 0 ? 60 + this.minutes - minutes : this.minutes - minutes);
    }

    void scale(int factor) {
        if (factor <= 0) return;
        int newTime = (this.hours*60 + this.minutes)*factor;
        this.hours = newTime / 60;
        this.minutes = newTime % 60;
    }
}