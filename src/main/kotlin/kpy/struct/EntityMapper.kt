package kpy.struct

/**
 * EntityMapper used for database mapper and service mapper
 * @author jakode2020
 * @since 1.0.0 2/13/2021
 */
interface EntityMapper<Entity, DomainModel> {
    fun mapFromEntity(entity: Entity): DomainModel
    fun mapToEntity(domainModel: DomainModel): Entity
}