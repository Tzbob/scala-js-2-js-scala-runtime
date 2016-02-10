package scalajs2jsscala

import scala.scalajs.js
import js.annotation.JSExport
import js.JSConverters._

@JSExport
object Runtime {
  // http://www.scala-js.org/doc/js-interoperability.html

  // convert from js.UndefOr
  @JSExport def encodeOptions[A](nullable: A): Option[A] = Option(nullable)
  @JSExport def encodeArray[A](arr: js.Array[A]): Seq[A] = arr
  @JSExport def encodeDict[A](dict: js.Dictionary[A]): collection.mutable.Map[String, A] = dict

  // http://www.scala-js.org/doc/calling-javascript.html
  @JSExport def encodeFn0[R](f: js.Function0[R]): Function0[R] = f
  @JSExport def encodeFn1[A, R](f: js.Function1[A, R]): Function1[A, R] = f
  @JSExport def encodeFn2[A, B, R](f: js.Function2[A, B, R]): Function2[A, B, R] = f
  @JSExport def encodeFn3[A, B, C, R](f: js.Function3[A, B, C, R]): Function3[A, B, C, R] = f

  @JSExport def encodeTup2[A, R](f: js.Object with js.Dynamic): Tuple2[A, R] =
    (f._1.asInstanceOf[A], f._2.asInstanceOf[R])
  @JSExport def encodeTup3[A, B, R](f: js.Object with js.Dynamic): Tuple3[A, B, R] =
    (f._1.asInstanceOf[A], f._2.asInstanceOf[B], f._3.asInstanceOf[R])
  @JSExport def encodeTup4[A, B, C, R](f: js.Object with js.Dynamic): Tuple4[A, B, C, R] =
    (f._1.asInstanceOf[A], f._2.asInstanceOf[B], f._3.asInstanceOf[C], f._4.asInstanceOf[R])

  @JSExport def decodeOptions[A >: Null](opt: Option[A]): A = null
  @JSExport def decodeSeq[A](arr: Seq[A]): js.Array[A] = arr.toJSArray
  @JSExport def decodeMap[A](dict: collection.mutable.Map[String, A]): js.Dictionary[A] =
    dict.toJSDictionary

  @JSExport def decodeFn0[R](f: Function0[R]): js.Function0[R] = f
  @JSExport def decodeFn1[A, R](f: Function1[A, R]): js.Function1[A, R] = f
  @JSExport def decodeFn2[A, B, R](f: Function2[A, B, R]): js.Function2[A, B, R] = f
  @JSExport def decodeFn3[A, B, C, R](f: Function3[A, B, C, R]): js.Function3[A, B, C, R] = f

  @JSExport def decodeTup2[A, R](f: Tuple2[A, R]): js.Object =
    js.Dynamic.literal(
      "_1" -> f._1.asInstanceOf[js.Any],
      "_2" -> f._2.asInstanceOf[js.Any]
    )
  @JSExport def decodeTup3[A, B, R](f: Tuple3[A, B, R]): js.Object =
    js.Dynamic.literal(
      "_1" -> f._1.asInstanceOf[js.Any],
      "_2" -> f._2.asInstanceOf[js.Any],
      "_3" -> f._3.asInstanceOf[js.Any]
    )
  @JSExport def decodeTup4[A, B, C, R](f: Tuple4[A, B, C, R]): js.Object =
    js.Dynamic.literal(
      "_1" -> f._1.asInstanceOf[js.Any],
      "_2" -> f._2.asInstanceOf[js.Any],
      "_3" -> f._3.asInstanceOf[js.Any],
      "_4" -> f._4.asInstanceOf[js.Any]
    )
}
