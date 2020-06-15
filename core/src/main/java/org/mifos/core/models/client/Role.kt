package org.mifos.core.models.client

/**
 * Created by grandolf49 on 06-06-2020
 */
class Role {
    private var id = 0
    private var name: String? = null
    private var description: String? = null

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String?) {
        this.description = description
    }

    override fun toString(): String {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}'
    }
}