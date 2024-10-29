class Captcha {
    constructor(id = "", name = "", use = "", hits = "", faults = "", lastDate = "") {
        this.id = id;
        this.name = name;
        this.link = id ? `http://localhost:8080/captchas/${id}.html` : "";
        this.use = use;
        this.hits = hits;
        this.faults = faults;
        this.lastDate = lastDate;
    }

    // Getters y Setters
    getId() {
        return this.id;
    }

    setId(id) {
        this.id = id;
        this.setLink(`http://localhost:8080/captchas/${id}.html`);
    }

    getName() {
        return this.name;
    }

    setName(name) {
        this.name = name;
    }

    getLink() {
        return this.link;
    }

    setLink(link) {
        this.link = link;
    }

    getUse() {
        return this.use;
    }

    setUse(use) {
        this.use = use;
    }

    getHits() {
        return this.hits;
    }

    setHits(hits) {
        this.hits = hits;
    }

    getFaults() {
        return this.faults;
    }

    setFaults(faults) {
        this.faults = faults;
    }

    getLastDate() {
        return this.lastDate;
    }

    setLastDate(lastDate) {
        this.lastDate = lastDate;
    }
}

module.exports = Captcha;