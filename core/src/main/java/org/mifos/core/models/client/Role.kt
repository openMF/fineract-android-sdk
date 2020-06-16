package org.mifos.core.models.client

/**
 * Created by grandolf49 on 06-06-2020
 */
data class Role(
    var id: Int = 0,
    var name: String? = null,
    var description: String? = null,
    var disabled: Boolean = false
) {

    override fun toString(): String {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}'
    }
}