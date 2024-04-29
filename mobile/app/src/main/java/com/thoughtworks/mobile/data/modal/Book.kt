package com.thoughtworks.mobile.data.modal

import android.os.Parcel
import android.os.Parcelable

data class Book(
    var id: Long?,
    var name: String,
    var author: String,
    var publicationYear: String,
    var isbn: String,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Long::class.java.classLoader) as? Long,
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        id?.let { dest.writeLong(id!!) }
        dest.writeString(name)
        dest.writeString(author)
        dest.writeString(publicationYear)
        dest.writeString(isbn)
    }

    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel): Book {
            return Book(parcel)
        }

        override fun newArray(size: Int): Array<Book?> {
            return arrayOfNulls(size)
        }
    }

}