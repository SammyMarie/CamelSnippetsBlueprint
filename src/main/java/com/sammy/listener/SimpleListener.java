package com.sammy.listener;

import org.infinispan.notifications.Listener;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryCreated;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryRemoved;
import org.infinispan.notifications.cachelistener.event.CacheEntryCreatedEvent;
import org.infinispan.notifications.cachelistener.event.CacheEntryRemovedEvent;
import org.infinispan.notifications.cachemanagerlistener.annotation.CacheStarted;
import org.infinispan.notifications.cachemanagerlistener.annotation.CacheStopped;
import org.infinispan.notifications.cachemanagerlistener.event.CacheStartedEvent;
import org.infinispan.notifications.cachemanagerlistener.event.CacheStoppedEvent;

/**
 * Created by samif on 19/11/2016.
 */
@Listener
public class SimpleListener {

    @CacheEntryCreated
    public void dataAdded(CacheEntryCreatedEvent createdEvent){
        if (createdEvent.isPre()){
            System.out.println("Going to add new entry " + createdEvent.getKey() + " created in the cache.");
        }else{
            System.out.println("Added new entry " + createdEvent.getKey() + " to the cache.");
        }
    }

    @CacheEntryRemoved
    public void dataRemoved(CacheEntryRemovedEvent removedEvent){
        if (removedEvent.isPre()){
            System.out.println("Going to remove entry " + removedEvent.getKey() + " created in the cache.");
        }else{
            System.out.println("Removed entry " + removedEvent.getKey() + " from the cache.");
        }
    }

    @CacheStarted
    public void cacheStarted(CacheStartedEvent startedEvent){
        System.out.println("Cache Started.");
    }

    @CacheStopped
    public void cacheStopped(CacheStoppedEvent stoppedEvent){
        System.out.println("Cache Stopped.");
    }
}