package org.mapsa.behavioral.iterator.radiochannels;

public interface ChannelCollection {
    void addChannel(Channel c);

    void removeChannel(Channel c);

    ChannelIterator iterator(ChannelTypeEnum type);
}
