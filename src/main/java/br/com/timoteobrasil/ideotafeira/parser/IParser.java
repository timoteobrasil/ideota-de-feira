package br.com.timoteobrasil.ideotafeira.parser;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface IParser<E, T> {
    E toEntity(T to);
    T toTO(E entity);

    default Stream<E> toStreamEntity(Collection<T> coll) {
        Stream<T> streamTO = Optional.ofNullable(coll)
            .map(Collection::stream)
            .orElseGet(Stream::empty);
        return streamTO.map(this::toEntity);
    }

    default List<E> toListEntity(Collection<T> coll) {
        return toStreamEntity(coll).toList();
    }

    default Stream<T> toStreamTO(Collection<E> coll) {
        Stream<E> streamEntity = Optional.ofNullable(coll)
            .map(Collection::stream)
            .orElseGet(Stream::empty);
        return streamEntity.map(this::toTO);
    }

    default List<T> toListTO(Collection<E> coll) {
        return toStreamTO(coll).toList();
    }

}
