package com.beetle.backend.entity

import jakarta.persistence.*

@Entity
@Table(name = "targets")
class TargetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "name")
    var name: String? = null

    @Column(name = "display_name")
    var displayName: String? = null

    @Column(name = "force_redeploy")
    var forceRedeploy: Boolean? = null

    @Column(name = "labels", columnDefinition = "TEXT")
    var labels: String? = null

    @OneToMany(mappedBy = "target", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var components: MutableList<TargetComponentEntity> = mutableListOf()

    @OneToMany(mappedBy = "target", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var topologies: MutableList<TopologyEntity> = mutableListOf()
}

@Entity
@Table(name = "target_components")
class TargetComponentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "name")
    var name: String? = null

    @Column(name = "type")
    var type: String? = null

    @Column(name = "properties", columnDefinition = "TEXT")
    var properties: String? = null

    @ManyToOne
    @JoinColumn(name = "target_id")
    var target: TargetEntity? = null
}

@Entity
@Table(name = "topologies")
class TopologyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "target_id")
    var target: TargetEntity? = null

    @OneToMany(mappedBy = "topology", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var bindings: MutableList<BindingEntity> = mutableListOf()
}

@Entity
@Table(name = "bindings")
class BindingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "role")
    var role: String? = null

    @Column(name = "provider")
    var provider: String? = null

    @Column(name = "config", columnDefinition = "TEXT")
    var config: String? = null

    @ManyToOne
    @JoinColumn(name = "topology_id")
    var topology: TopologyEntity? = null
}