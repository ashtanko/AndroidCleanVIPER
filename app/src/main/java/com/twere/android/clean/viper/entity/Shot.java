package com.twere.android.clean.viper.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class Shot implements Parcelable {

  public static final String LIST_ANIMATED = "animated";
  public static final String LIST_ATTACHMENTS = "attachments";
  public static final String LIST_DEBUTS = "debuts";
  public static final String LIST_PLAYOFFS = "playoffs";
  public static final String LIST_REBOUNDS = "rebounds";
  public static final String LIST_TEAMS = "teams";

  public static final String TIMEFRAME_WEEK = "week";
  public static final String TIMEFRAME_MONTH = "month";
  public static final String TIMEFRAME_YEAR = "year";
  public static final String TIMEFRAME_EVER = "ever";

  public static final String SORT_COMMENTS = "comments";
  public static final String SORT_RECENT = "recent";
  public static final String SORT_VIEWS = "views";

  @SerializedName("id") private long id;

  @SerializedName("title") private String title;

  @SerializedName("description") private String description;

  @SerializedName("width") private int width;

  @SerializedName("height") private int height;

  @SerializedName("images") private Images images;

  @SerializedName("views_count") private long viewsCount;

  @SerializedName("likes_count") private long likesCount;

  @SerializedName("comments_count") private long commentsCount;

  @SerializedName("attachments_count") private long attachmentsCount;

  @SerializedName("rebounds_count") private long reboundsCount;

  @SerializedName("buckets_count") private long bucketsCount;

  @SerializedName("created_at") private Date createdAt;

  @SerializedName("updated_at") private Date updatedAt;

  @SerializedName("html_url") private String htmlUrl;

  @SerializedName("attachments_url") private String attachmentsUrl;

  @SerializedName("buckets_url") private String bucketsUrl;

  @SerializedName("comments_url") private String commentsUrl;

  @SerializedName("likes_url") private String likesUrl;

  @SerializedName("projects_url") private String projectsUrl;

  @SerializedName("rebounds_url") private String reboundsUrl;

  @SerializedName("tags") private String[] tags;

    /*
    "tags" : [
    "fiction",
    "sasquatch",
    "sketch",
    "wip"
  ],
     */

  @SerializedName("user") private User user;

  @SerializedName("team") private Team team;

  private boolean seen;

  protected Shot(Parcel in) {
    id = in.readLong();
    title = in.readString();
    description = in.readString();
    width = in.readInt();
    height = in.readInt();
    viewsCount = in.readLong();
    likesCount = in.readLong();
    commentsCount = in.readLong();
    attachmentsCount = in.readLong();
    reboundsCount = in.readLong();
    bucketsCount = in.readLong();
    htmlUrl = in.readString();
    attachmentsUrl = in.readString();
    bucketsUrl = in.readString();
    commentsUrl = in.readString();
    likesUrl = in.readString();
    projectsUrl = in.readString();
    reboundsUrl = in.readString();
    tags = in.createStringArray();
    seen = in.readByte() != 0;
  }

  public static final Creator<Shot> CREATOR = new Creator<Shot>() {
    @Override public Shot createFromParcel(Parcel in) {
      return new Shot(in);
    }

    @Override public Shot[] newArray(int size) {
      return new Shot[size];
    }
  };

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public Images getImages() {
    return images;
  }

  public void setImages(Images images) {
    this.images = images;
  }

  public long getViewsCount() {
    return viewsCount;
  }

  public void setViewsCount(long viewsCount) {
    this.viewsCount = viewsCount;
  }

  public long getLikesCount() {
    return likesCount;
  }

  public void setLikesCount(long likesCount) {
    this.likesCount = likesCount;
  }

  public long getCommentsCount() {
    return commentsCount;
  }

  public void setCommentsCount(long commentsCount) {
    this.commentsCount = commentsCount;
  }

  public long getAttachmentsCount() {
    return attachmentsCount;
  }

  public void setAttachmentsCount(long attachmentsCount) {
    this.attachmentsCount = attachmentsCount;
  }

  public long getReboundsCount() {
    return reboundsCount;
  }

  public void setReboundsCount(long reboundsCount) {
    this.reboundsCount = reboundsCount;
  }

  public long getBucketsCount() {
    return bucketsCount;
  }

  public void setBucketsCount(long bucketsCount) {
    this.bucketsCount = bucketsCount;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getHtmlUrl() {
    return htmlUrl;
  }

  public void setHtmlUrl(String htmlUrl) {
    this.htmlUrl = htmlUrl;
  }

  public String getAttachmentsUrl() {
    return attachmentsUrl;
  }

  public void setAttachmentsUrl(String attachmentsUrl) {
    this.attachmentsUrl = attachmentsUrl;
  }

  public String getBucketsUrl() {
    return bucketsUrl;
  }

  public void setBucketsUrl(String bucketsUrl) {
    this.bucketsUrl = bucketsUrl;
  }

  public String getCommentsUrl() {
    return commentsUrl;
  }

  public void setCommentsUrl(String commentsUrl) {
    this.commentsUrl = commentsUrl;
  }

  public String getLikesUrl() {
    return likesUrl;
  }

  public void setLikesUrl(String likesUrl) {
    this.likesUrl = likesUrl;
  }

  public String getProjectsUrl() {
    return projectsUrl;
  }

  public void setProjectsUrl(String projectsUrl) {
    this.projectsUrl = projectsUrl;
  }

  public String getReboundsUrl() {
    return reboundsUrl;
  }

  public void setReboundsUrl(String reboundsUrl) {
    this.reboundsUrl = reboundsUrl;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

  public boolean isSeen() {
    return seen;
  }

  public void setSeen(boolean seen) {
    this.seen = seen;
  }

  public String[] getTags() {
    return tags;
  }

  public void setTags(String[] tags) {
    this.tags = tags;
  }

  private JSONObject toJson() {
    JSONObject result = new JSONObject();
    try {
      result.put("id", id);
      result.put("title", title);
      result.put("description", description);
      result.put("width", width);
      result.put("height", height);

      if (images != null) {
        result.put("images", images.toJson());
      }

      result.put("views_count", viewsCount);
      result.put("likes_count", likesCount);
      result.put("comments_count", commentsCount);
      result.put("attachments_count", attachmentsCount);
      result.put("rebounds_count", reboundsCount);
      result.put("buckets_count", bucketsCount);
      result.put("created_at", createdAt);
      result.put("updated_at", updatedAt);
      result.put("html_url", htmlUrl);
      result.put("attachments_url", attachmentsUrl);
      result.put("buckets_url", bucketsUrl);
      result.put("comments_url", commentsUrl);
      result.put("likes_url", likesUrl);
      result.put("projects_url", projectsUrl);
      result.put("rebounds_url", reboundsUrl);
      result.put("tags", tags);

      if (user != null) {
        result.put("user", user.toJson());
      }

      if (team != null) {
        result.put("team", team.toJson());
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }

    return result;
  }

  public String toGson() {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    return gson.toJson(this);
  }

  @Override public String toString() {
    try {
      return toJson().toString(4);
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel parcel, int i) {
    parcel.writeLong(id);
    parcel.writeString(title);
    parcel.writeString(description);
    parcel.writeInt(width);
    parcel.writeInt(height);
    parcel.writeLong(viewsCount);
    parcel.writeLong(likesCount);
    parcel.writeLong(commentsCount);
    parcel.writeLong(attachmentsCount);
    parcel.writeLong(reboundsCount);
    parcel.writeLong(bucketsCount);
    parcel.writeString(htmlUrl);
    parcel.writeString(attachmentsUrl);
    parcel.writeString(bucketsUrl);
    parcel.writeString(commentsUrl);
    parcel.writeString(likesUrl);
    parcel.writeString(projectsUrl);
    parcel.writeString(reboundsUrl);
    parcel.writeStringArray(tags);
    parcel.writeByte((byte) (seen ? 1 : 0));
  }
}