package br.com.web3clubtravel.blog.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.web3clubtravel.blog.model.Destinations;

public class DestinationsDto {

    private String climate;
    private String localCurrency;
    private String transport;
    private String accommodation;
    private String sightseeing;
    private String gastronomy;
    private String language;
    private String documents;
    private String security;
    private String costs;
    private String health;
    private String culture;
    private String shopping;
    private String events;
    private String distances;
    private String schedules;
    private String internetConnection;
    private String baggageTransport;
    private String extraTips;
    private String usefulInformation;
    private String meansPayment;
    private String contactInformation;
    private String imageLink;
    private String city;
    
    @JsonIgnore
    private String reference; // TODO FIELD REPRESENTED BY THE AGGREGATION OF THE STRINGS

    public DestinationsDto() {}

    public DestinationsDto(String city) {
        this.city = city;
    }

    public DestinationsDto(String imageLink, String city) {
        this.imageLink = imageLink;
        this.city = city;
    }

    public DestinationsDto(String climate, String localCurrency, String transport, String accommodation,
            String sightseeing, String gastronomy, String language, String documents, String security, String costs,
            String health, String culture, String shopping, String events, String distances, String schedules,
            String internetConnection, String baggageTransport, String extraTips, String usefulInformation,
            String meansPayment, String contactInformation, String imageLink, String city) {
        this.climate = climate;
        this.localCurrency = localCurrency;
        this.transport = transport;
        this.accommodation = accommodation;
        this.sightseeing = sightseeing;
        this.gastronomy = gastronomy;
        this.language = language;
        this.documents = documents;
        this.security = security;
        this.costs = costs;
        this.health = health;
        this.culture = culture;
        this.shopping = shopping;
        this.events = events;
        this.distances = distances;
        this.schedules = schedules;
        this.internetConnection = internetConnection;
        this.baggageTransport = baggageTransport;
        this.extraTips = extraTips;
        this.usefulInformation = usefulInformation;
        this.meansPayment = meansPayment;
        this.contactInformation = contactInformation;
        this.imageLink = imageLink;
        this.city = city;
    }

    public static DestinationsDto of(Destinations destination) {
        final var dto = new DestinationsDto(destination.getImageLink(),
                destination.getCity().getName());
        dto.transformReferenceInAttributes(destination.getReference());
        return dto;
    }

    public String transformAttributesInReference() {
        StringBuilder reference = new StringBuilder();

        reference.append(this.climate);
        reference.append(", ");
        reference.append(this.localCurrency);
        reference.append(", ");
        reference.append(this.transport);
        reference.append(", ");
        reference.append(this.accommodation);
        reference.append(", ");
        reference.append(this.sightseeing);
        reference.append(", ");
        reference.append(this.gastronomy);
        reference.append(", ");
        reference.append(this.language);
        reference.append(", ");
        reference.append(this.documents);
        reference.append(", ");
        reference.append(this.security);
        reference.append(", ");
        reference.append(this.costs);
        reference.append(", ");
        reference.append(this.health);
        reference.append(", ");
        reference.append(this.culture);
        reference.append(", ");
        reference.append(this.shopping);
        reference.append(", ");
        reference.append(this.events);
        reference.append(", ");
        reference.append(this.distances);
        reference.append(", ");
        reference.append(this.schedules);
        reference.append(", ");
        reference.append(this.internetConnection);
        reference.append(", ");
        reference.append(this.baggageTransport);
        reference.append(", ");
        reference.append(this.extraTips);
        reference.append(", ");
        reference.append(this.usefulInformation);
        reference.append(", ");
        reference.append(this.meansPayment);
        reference.append(", ");
        reference.append(this.contactInformation);
        reference.append(", ");
        reference.append(this.reference);
        reference.append(", ");
        reference.append(this.imageLink);
        reference.append(", ");
        reference.append(this.city);        

        return reference.toString();
    }

    public void transformReferenceInAttributes(String reference) {
        String[] stra = reference.split(", ");

        this.climate = stra[0];
        this.localCurrency = stra[1];
        this.transport = stra[2];
        this.accommodation = stra[3];
        this.sightseeing = stra[4];
        this.gastronomy = stra[5];
        this.language = stra[6];
        this.documents = stra[7];
        this.security = stra[8];
        this.costs = stra[9];
        this.health = stra[10];
        this.culture = stra[11];
        this.shopping = stra[12];
        this.events = stra[13];
        this.distances = stra[14];
        this.schedules = stra[15];
        this.internetConnection = stra[16];
        this.baggageTransport = stra[17];
        this.extraTips = stra[19];
        this.usefulInformation = stra[20];
        this.meansPayment = stra[21];
        this.contactInformation = stra[22];
        this.imageLink = stra[23];
        this.city = stra[24];        
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getLocalCurrency() {
        return localCurrency;
    }

    public void setLocalCurrency(String localCurrency) {
        this.localCurrency = localCurrency;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }

    public String getSightseeing() {
        return sightseeing;
    }

    public void setSightseeing(String sightseeing) {
        this.sightseeing = sightseeing;
    }

    public String getGastronomy() {
        return gastronomy;
    }

    public void setGastronomy(String gastronomy) {
        this.gastronomy = gastronomy;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getCosts() {
        return costs;
    }

    public void setCosts(String costs) {
        this.costs = costs;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getShopping() {
        return shopping;
    }

    public void setShopping(String shopping) {
        this.shopping = shopping;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    public String getDistances() {
        return distances;
    }

    public void setDistances(String distances) {
        this.distances = distances;
    }

    public String getSchedules() {
        return schedules;
    }

    public void setSchedules(String schedules) {
        this.schedules = schedules;
    }

    public String getInternetConnection() {
        return internetConnection;
    }

    public void setInternetConnection(String internetConnection) {
        this.internetConnection = internetConnection;
    }

    public String getBaggageTransport() {
        return baggageTransport;
    }

    public void setBaggageTransport(String baggageTransport) {
        this.baggageTransport = baggageTransport;
    }

    public String getExtraTips() {
        return extraTips;
    }

    public void setExtraTips(String extraTips) {
        this.extraTips = extraTips;
    }

    public String getUsefulInformation() {
        return usefulInformation;
    }

    public void setUsefulInformation(String usefulInformation) {
        this.usefulInformation = usefulInformation;
    }

    public String getMeansPayment() {
        return meansPayment;
    }

    public void setMeansPayment(String meansPayment) {
        this.meansPayment = meansPayment;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
