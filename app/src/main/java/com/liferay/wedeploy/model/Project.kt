package com.liferay.wedeploy.model

import com.liferay.wedeploy.util.Constants


/**
 * @author Albertinin Santos
 */

class Project(val id: String, val projectId: String, val health: String, val masterToken: String, val ownerId: String): Comparable <Project>{



    fun isHealthy(): Boolean {
        return this.health == Constants.HEALTHY
    }

    fun isUnhealthy(): Boolean {
        return this.health == Constants.UNHEALTHY
    }

    override fun compareTo(other: Project): Int {
        if(this.id.equals("unhealthy")){
            if(other.health.equals("unhealthy")) return 0
            return -1
        }
        if(other.health.equals("unhealthy")) return 1
        return 0
    }

}