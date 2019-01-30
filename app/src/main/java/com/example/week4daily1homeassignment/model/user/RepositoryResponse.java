
package com.example.week4daily1homeassignment.model.user;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RepositoryResponse implements Parcelable
{

    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("incomplete_results")
    @Expose
    private Boolean incompleteResults;
    @SerializedName("items")
    @Expose
    private List<RepoItem> repoItems = null;
    public final static Creator<RepositoryResponse> CREATOR = new Creator<RepositoryResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RepositoryResponse createFromParcel(Parcel in) {
            return new RepositoryResponse(in);
        }

        public RepositoryResponse[] newArray(int size) {
            return (new RepositoryResponse[size]);
        }

    }
    ;

    protected RepositoryResponse(Parcel in) {
        this.totalCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.incompleteResults = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        in.readList(this.repoItems, (Item.class.getClassLoader()));
    }

    public RepositoryResponse() {
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    public void setIncompleteResults(Boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    public List<RepoItem> getItems() {
        return repoItems;
    }

    public void setItems(List<RepoItem> items) {
        this.repoItems = items;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(totalCount);
        dest.writeValue(incompleteResults);
        dest.writeList(repoItems);
    }

    public int describeContents() {
        return  0;
    }

}
