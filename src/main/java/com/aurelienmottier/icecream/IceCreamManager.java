package com.aurelienmottier.icecream;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class IceCreamManager {

    private static final AtomicLong COUNTER = new AtomicLong(1);

    private final Map<Long, IceCream> cache;

    public IceCreamManager() {
        this.cache = new HashMap<>();
        this.cache.put(1L, new IceCream(COUNTER.getAndIncrement(), "Green Mon'", "Matcha"));
        this.cache.put(2L, new IceCream(COUNTER.getAndIncrement(), "Dark Mon'", "Chocolate"));
        this.cache.put(3L, new IceCream(COUNTER.getAndIncrement(), "Red Mon'", "Strawberry"));
    }

    public Collection<IceCream> get() {
        return this.cache.values();
    }

    public IceCream create(final IceCream iceCreamToCreate) {
        final Long newIceCreamId = COUNTER.getAndIncrement();
        final IceCream newIceCream = new IceCream(newIceCreamId, iceCreamToCreate.name(), iceCreamToCreate.flavor());
        this.cache.put(newIceCreamId, newIceCream);
        return newIceCream;
    }

}