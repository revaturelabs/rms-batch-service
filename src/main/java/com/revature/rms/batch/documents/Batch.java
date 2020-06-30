package com.revature.rms.batch.documents;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.revature.rms.core.models.Resource;
import com.revature.rms.core.models.ResourceMetadata;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Document
@JsonPropertyOrder({
    "id",
    "name",
    "trainingTrackId",
    "startDateTime",
    "endDateTime",
    "trainerId",
    "coTrainerId",
    "associateIds",
    "metadata"
})
public class Batch extends Resource {

    @NotEmpty
    private String name;

    @NotEmpty
    private String trainingTrackId;

    @NotNull
    private LocalDateTime startDateTime;

    @NotNull
    private LocalDateTime endDateTime;

    @NotEmpty
    private String trainerId;

    @NotEmpty
    private String coTrainerId;

    @NotEmpty
    private List<String> associateIds;

    public Batch() {
        super();
    }

    public Batch(@NotEmpty String name, @NotNull LocalDateTime startDateTime, @NotNull LocalDateTime endDateTime,
                 @NotEmpty String trainerId, @NotEmpty String coTrainerId, @NotEmpty List<String> associateIds,
                 @NotEmpty String trainingTrackId) {
        this.name = name;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.trainerId = trainerId;
        this.coTrainerId = coTrainerId;
        this.associateIds = associateIds;
        this.trainingTrackId = trainingTrackId;
    }

    public Batch(@NotEmpty String name, @NotNull LocalDateTime startDateTime, @NotNull LocalDateTime endDateTime,
                 @NotEmpty String trainerId, @NotEmpty String coTrainerId, @NotEmpty List<String> associateIds,
                 @NotEmpty String trainingTrackId, @NotNull ResourceMetadata metadata) {
        this(name, startDateTime, endDateTime, trainerId, coTrainerId, associateIds, trainingTrackId);
        this.metadata = metadata;
    }

    public Batch(String id, @NotEmpty String name, @NotNull LocalDateTime startDateTime, @NotNull LocalDateTime endDateTime,
                 @NotEmpty String trainerId, @NotEmpty String coTrainerId, @NotEmpty List<String> associateIds,
                 @NotEmpty String trainingTrackId, @NotNull ResourceMetadata metadata) {
        this(name, startDateTime, endDateTime, trainerId, coTrainerId, associateIds, trainingTrackId, metadata);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Batch setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public Batch setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
        return this;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public Batch setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
        return this;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public Batch setTrainerId(String trainerId) {
        this.trainerId = trainerId;
        return this;
    }

    public String getCoTrainerId() {
        return coTrainerId;
    }

    public Batch setCoTrainerId(String coTrainerId) {
        this.coTrainerId = coTrainerId;
        return this;
    }

    public List<String> getAssociateIds() {
        return associateIds;
    }

    public Batch setAssociateIds(List<String> associateIds) {
        this.associateIds = associateIds;
        return this;
    }

    public String getTrainingTrackId() {
        return trainingTrackId;
    }

    public Batch setTrainingTrackId(String trainingTrackId) {
        this.trainingTrackId = trainingTrackId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Batch batch = (Batch) o;
        return Objects.equals(name, batch.name) &&
                Objects.equals(startDateTime, batch.startDateTime) &&
                Objects.equals(endDateTime, batch.endDateTime) &&
                Objects.equals(trainerId, batch.trainerId) &&
                Objects.equals(coTrainerId, batch.coTrainerId) &&
                Objects.equals(associateIds, batch.associateIds) &&
                trainingTrackId == batch.trainingTrackId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startDateTime, endDateTime, trainerId, coTrainerId, associateIds, trainingTrackId);
    }

    @Override
    public String toString() {
        return "Batch{" +
                "name='" + name + '\'' +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                ", trainerId='" + trainerId + '\'' +
                ", coTrainerId='" + coTrainerId + '\'' +
                ", associateIds=" + associateIds +
                ", trainingTrack=" + trainingTrackId +
                '}';
    }

}
