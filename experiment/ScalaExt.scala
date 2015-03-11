import scala.reflect.ClassTag

object ScalaExt {

  type EndoFn[A] = A => A

  @inline final def none[A]: Option[A] = None

  implicit class BaseUtilExtAny[A](val _a: A) extends AnyVal {
    @inline def |>          [B]   (f: A => B)           : B      = f(_a)
    @inline def mapStrengthL[B]   (f: A => B)           : (B, A) = (f(_a), _a)
    @inline def mapStrengthR[B]   (f: A => B)           : (A, B) = (_a, f(_a))
    @inline def tmap2       [B, C](b: A => B, c: A => C): (B, C) = (b(_a), c(_a))

    @inline def ifelse[B](c: A => Boolean, t: A => B, f: A => B): B =
      if (c(_a)) t(_a) else f(_a)

    @inline def some: Option[A] = Some(_a)
  }

  implicit class StringBuilderExt(val sb: StringBuilder) extends AnyVal {
    @inline def kv(k: String, v: Any): Unit = {
      sb append k
      sb append " = "
      sb append v
    }
    @inline def kv(k: String, v: Any, cond: Boolean): Unit = if (cond) kv(k, v)

    def mkStringF(start: String, sep: String, end: String)(fs: (StringBuilder => Any)*): Unit = {
      sb append start
      var nextSep = false
      for (f <- fs) {
        if (nextSep) sb append sep
        val b = sb.length
        f(sb)
        nextSep = sb.length != b
      }
      if (!nextSep) // undo sep if last function was NOP
        sb.setLength(sb.length - sep.length)
      sb append end
    }
  }

  implicit class FuckingSomeExt[A](val s: Some[A]) extends AnyVal {
    @inline def castOption: Option[A] = s.asInstanceOf[Option[A]]
  }

  implicit class IterableExt[A](val _a: Iterable[A]) extends AnyVal {
    def filterT[T <: A](implicit t: ClassTag[T]): Stream[T] =
      _a.toStream.flatMap(t.unapply(_).toStream)
  }

  // Generated by bin/gen-function_ext

  @inline final implicit class Function2Ext[A,B,R](val _x: (A,B) ⇒ R) extends AnyVal {
    @inline def andThenA[Z](y: R⇒Z): (A,B)⇒Z = (a,b)⇒y(_x(a,b))
  }
  @inline final implicit class Function3Ext[A,B,C,R](val _x: (A,B,C) ⇒ R) extends AnyVal {
    @inline def andThenA[Z](y: R⇒Z): (A,B,C)⇒Z = (a,b,c)⇒y(_x(a,b,c))
  }
  @inline final implicit class Function4Ext[A,B,C,D,R](val _x: (A,B,C,D) ⇒ R) extends AnyVal {
    @inline def andThenA[Z](y: R⇒Z): (A,B,C,D)⇒Z = (a,b,c,d)⇒y(_x(a,b,c,d))
  }
  @inline final implicit class Function5Ext[A,B,C,D,E,R](val _x: (A,B,C,D,E) ⇒ R) extends AnyVal {
    @inline def andThenA[Z](y: R⇒Z): (A,B,C,D,E)⇒Z = (a,b,c,d,e)⇒y(_x(a,b,c,d,e))
  }
  @inline final implicit class Function6Ext[A,B,C,D,E,F,R](val _x: (A,B,C,D,E,F) ⇒ R) extends AnyVal {
    @inline def andThenA[Z](y: R⇒Z): (A,B,C,D,E,F)⇒Z = (a,b,c,d,e,f)⇒y(_x(a,b,c,d,e,f))
  }
  @inline final implicit class Function7Ext[A,B,C,D,E,F,G,R](val _x: (A,B,C,D,E,F,G) ⇒ R) extends AnyVal {
    @inline def andThenA[Z](y: R⇒Z): (A,B,C,D,E,F,G)⇒Z = (a,b,c,d,e,f,g)⇒y(_x(a,b,c,d,e,f,g))
  }
  @inline final implicit class Function8Ext[A,B,C,D,E,F,G,H,R](val _x: (A,B,C,D,E,F,G,H) ⇒ R) extends AnyVal {
    @inline def andThenA[Z](y: R⇒Z): (A,B,C,D,E,F,G,H)⇒Z = (a,b,c,d,e,f,g,h)⇒y(_x(a,b,c,d,e,f,g,h))
  }
  @inline final implicit class Function9Ext[A,B,C,D,E,F,G,H,I,R](val _x: (A,B,C,D,E,F,G,H,I) ⇒ R) extends AnyVal {
    @inline def andThenA[Z](y: R⇒Z): (A,B,C,D,E,F,G,H,I)⇒Z = (a,b,c,d,e,f,g,h,i)⇒y(_x(a,b,c,d,e,f,g,h,i))
  }
  @inline final implicit class Function1Ext[X,Y](val _x: X ⇒ Y) extends AnyVal {
    @inline def composeA[A,B](y: (A,B)⇒X): (A,B)⇒Y = y andThenA _x
    @inline def composeA[A,B,C](y: (A,B,C)⇒X): (A,B,C)⇒Y = y andThenA _x
    @inline def composeA[A,B,C,D](y: (A,B,C,D)⇒X): (A,B,C,D)⇒Y = y andThenA _x
    @inline def composeA[A,B,C,D,E](y: (A,B,C,D,E)⇒X): (A,B,C,D,E)⇒Y = y andThenA _x
    @inline def composeA[A,B,C,D,E,F](y: (A,B,C,D,E,F)⇒X): (A,B,C,D,E,F)⇒Y = y andThenA _x
    @inline def composeA[A,B,C,D,E,F,G](y: (A,B,C,D,E,F,G)⇒X): (A,B,C,D,E,F,G)⇒Y = y andThenA _x
    @inline def composeA[A,B,C,D,E,F,G,H](y: (A,B,C,D,E,F,G,H)⇒X): (A,B,C,D,E,F,G,H)⇒Y = y andThenA _x
    @inline def composeA[A,B,C,D,E,F,G,H,I](y: (A,B,C,D,E,F,G,H,I)⇒X): (A,B,C,D,E,F,G,H,I)⇒Y = y andThenA _x
    def overTuple2: HomoTuple2Map[X,Y] = _ mapEach _x
    def overTuple3: HomoTuple3Map[X,Y] = _ mapEach _x
    def overTuple4: HomoTuple4Map[X,Y] = _ mapEach _x
    def overTuple5: HomoTuple5Map[X,Y] = _ mapEach _x
    def overTuple6: HomoTuple6Map[X,Y] = _ mapEach _x
    def overTuple7: HomoTuple7Map[X,Y] = _ mapEach _x
    def overTuple8: HomoTuple8Map[X,Y] = _ mapEach _x
    def overTuple9: HomoTuple9Map[X,Y] = _ mapEach _x
  }

  // Generated by bin/gen-tuple_ext

  @inline final implicit class Tuple2Ext[A, B](val _t: (A, B)) extends AnyVal {
    @inline def map1[X](f: A => X): (X, B) = (f(_t._1), _t._2)
    @inline def map2[X](f: B => X): (A, X) = (_t._1, f(_t._2))
    @inline def put1[X](x: X): (X, B) = (x, _t._2)
    @inline def put2[X](x: X): (A, X) = (_t._1, x)
  }
  @inline final implicit class Tuple3Ext[A, B, C](val _t: (A, B, C)) extends AnyVal {
    @inline def map1[X](f: A => X): (X, B, C) = (f(_t._1), _t._2, _t._3)
    @inline def map2[X](f: B => X): (A, X, C) = (_t._1, f(_t._2), _t._3)
    @inline def map3[X](f: C => X): (A, B, X) = (_t._1, _t._2, f(_t._3))
    @inline def put1[X](x: X): (X, B, C) = (x, _t._2, _t._3)
    @inline def put2[X](x: X): (A, X, C) = (_t._1, x, _t._3)
    @inline def put3[X](x: X): (A, B, X) = (_t._1, _t._2, x)
  }
  @inline final implicit class Tuple4Ext[A, B, C, D](val _t: (A, B, C, D)) extends AnyVal {
    @inline def map1[X](f: A => X): (X, B, C, D) = (f(_t._1), _t._2, _t._3, _t._4)
    @inline def map2[X](f: B => X): (A, X, C, D) = (_t._1, f(_t._2), _t._3, _t._4)
    @inline def map3[X](f: C => X): (A, B, X, D) = (_t._1, _t._2, f(_t._3), _t._4)
    @inline def map4[X](f: D => X): (A, B, C, X) = (_t._1, _t._2, _t._3, f(_t._4))
    @inline def put1[X](x: X): (X, B, C, D) = (x, _t._2, _t._3, _t._4)
    @inline def put2[X](x: X): (A, X, C, D) = (_t._1, x, _t._3, _t._4)
    @inline def put3[X](x: X): (A, B, X, D) = (_t._1, _t._2, x, _t._4)
    @inline def put4[X](x: X): (A, B, C, X) = (_t._1, _t._2, _t._3, x)
  }
  @inline final implicit class Tuple5Ext[A, B, C, D, E](val _t: (A, B, C, D, E)) extends AnyVal {
    @inline def map1[X](f: A => X): (X, B, C, D, E) = (f(_t._1), _t._2, _t._3, _t._4, _t._5)
    @inline def map2[X](f: B => X): (A, X, C, D, E) = (_t._1, f(_t._2), _t._3, _t._4, _t._5)
    @inline def map3[X](f: C => X): (A, B, X, D, E) = (_t._1, _t._2, f(_t._3), _t._4, _t._5)
    @inline def map4[X](f: D => X): (A, B, C, X, E) = (_t._1, _t._2, _t._3, f(_t._4), _t._5)
    @inline def map5[X](f: E => X): (A, B, C, D, X) = (_t._1, _t._2, _t._3, _t._4, f(_t._5))
    @inline def put1[X](x: X): (X, B, C, D, E) = (x, _t._2, _t._3, _t._4, _t._5)
    @inline def put2[X](x: X): (A, X, C, D, E) = (_t._1, x, _t._3, _t._4, _t._5)
    @inline def put3[X](x: X): (A, B, X, D, E) = (_t._1, _t._2, x, _t._4, _t._5)
    @inline def put4[X](x: X): (A, B, C, X, E) = (_t._1, _t._2, _t._3, x, _t._5)
    @inline def put5[X](x: X): (A, B, C, D, X) = (_t._1, _t._2, _t._3, _t._4, x)
  }
  @inline final implicit class Tuple6Ext[A, B, C, D, E, F](val _t: (A, B, C, D, E, F)) extends AnyVal {
    @inline def map1[X](f: A => X): (X, B, C, D, E, F) = (f(_t._1), _t._2, _t._3, _t._4, _t._5, _t._6)
    @inline def map2[X](f: B => X): (A, X, C, D, E, F) = (_t._1, f(_t._2), _t._3, _t._4, _t._5, _t._6)
    @inline def map3[X](f: C => X): (A, B, X, D, E, F) = (_t._1, _t._2, f(_t._3), _t._4, _t._5, _t._6)
    @inline def map4[X](f: D => X): (A, B, C, X, E, F) = (_t._1, _t._2, _t._3, f(_t._4), _t._5, _t._6)
    @inline def map5[X](f: E => X): (A, B, C, D, X, F) = (_t._1, _t._2, _t._3, _t._4, f(_t._5), _t._6)
    @inline def map6[X](f: F => X): (A, B, C, D, E, X) = (_t._1, _t._2, _t._3, _t._4, _t._5, f(_t._6))
    @inline def put1[X](x: X): (X, B, C, D, E, F) = (x, _t._2, _t._3, _t._4, _t._5, _t._6)
    @inline def put2[X](x: X): (A, X, C, D, E, F) = (_t._1, x, _t._3, _t._4, _t._5, _t._6)
    @inline def put3[X](x: X): (A, B, X, D, E, F) = (_t._1, _t._2, x, _t._4, _t._5, _t._6)
    @inline def put4[X](x: X): (A, B, C, X, E, F) = (_t._1, _t._2, _t._3, x, _t._5, _t._6)
    @inline def put5[X](x: X): (A, B, C, D, X, F) = (_t._1, _t._2, _t._3, _t._4, x, _t._6)
    @inline def put6[X](x: X): (A, B, C, D, E, X) = (_t._1, _t._2, _t._3, _t._4, _t._5, x)
  }
  @inline final implicit class Tuple7Ext[A, B, C, D, E, F, G](val _t: (A, B, C, D, E, F, G)) extends AnyVal {
    @inline def map1[X](f: A => X): (X, B, C, D, E, F, G) = (f(_t._1), _t._2, _t._3, _t._4, _t._5, _t._6, _t._7)
    @inline def map2[X](f: B => X): (A, X, C, D, E, F, G) = (_t._1, f(_t._2), _t._3, _t._4, _t._5, _t._6, _t._7)
    @inline def map3[X](f: C => X): (A, B, X, D, E, F, G) = (_t._1, _t._2, f(_t._3), _t._4, _t._5, _t._6, _t._7)
    @inline def map4[X](f: D => X): (A, B, C, X, E, F, G) = (_t._1, _t._2, _t._3, f(_t._4), _t._5, _t._6, _t._7)
    @inline def map5[X](f: E => X): (A, B, C, D, X, F, G) = (_t._1, _t._2, _t._3, _t._4, f(_t._5), _t._6, _t._7)
    @inline def map6[X](f: F => X): (A, B, C, D, E, X, G) = (_t._1, _t._2, _t._3, _t._4, _t._5, f(_t._6), _t._7)
    @inline def map7[X](f: G => X): (A, B, C, D, E, F, X) = (_t._1, _t._2, _t._3, _t._4, _t._5, _t._6, f(_t._7))
    @inline def put1[X](x: X): (X, B, C, D, E, F, G) = (x, _t._2, _t._3, _t._4, _t._5, _t._6, _t._7)
    @inline def put2[X](x: X): (A, X, C, D, E, F, G) = (_t._1, x, _t._3, _t._4, _t._5, _t._6, _t._7)
    @inline def put3[X](x: X): (A, B, X, D, E, F, G) = (_t._1, _t._2, x, _t._4, _t._5, _t._6, _t._7)
    @inline def put4[X](x: X): (A, B, C, X, E, F, G) = (_t._1, _t._2, _t._3, x, _t._5, _t._6, _t._7)
    @inline def put5[X](x: X): (A, B, C, D, X, F, G) = (_t._1, _t._2, _t._3, _t._4, x, _t._6, _t._7)
    @inline def put6[X](x: X): (A, B, C, D, E, X, G) = (_t._1, _t._2, _t._3, _t._4, _t._5, x, _t._7)
    @inline def put7[X](x: X): (A, B, C, D, E, F, X) = (_t._1, _t._2, _t._3, _t._4, _t._5, _t._6, x)
  }
  @inline final implicit class Tuple8Ext[A, B, C, D, E, F, G, H](val _t: (A, B, C, D, E, F, G, H)) extends AnyVal {
    @inline def map1[X](f: A => X): (X, B, C, D, E, F, G, H) = (f(_t._1), _t._2, _t._3, _t._4, _t._5, _t._6, _t._7, _t._8)
    @inline def map2[X](f: B => X): (A, X, C, D, E, F, G, H) = (_t._1, f(_t._2), _t._3, _t._4, _t._5, _t._6, _t._7, _t._8)
    @inline def map3[X](f: C => X): (A, B, X, D, E, F, G, H) = (_t._1, _t._2, f(_t._3), _t._4, _t._5, _t._6, _t._7, _t._8)
    @inline def map4[X](f: D => X): (A, B, C, X, E, F, G, H) = (_t._1, _t._2, _t._3, f(_t._4), _t._5, _t._6, _t._7, _t._8)
    @inline def map5[X](f: E => X): (A, B, C, D, X, F, G, H) = (_t._1, _t._2, _t._3, _t._4, f(_t._5), _t._6, _t._7, _t._8)
    @inline def map6[X](f: F => X): (A, B, C, D, E, X, G, H) = (_t._1, _t._2, _t._3, _t._4, _t._5, f(_t._6), _t._7, _t._8)
    @inline def map7[X](f: G => X): (A, B, C, D, E, F, X, H) = (_t._1, _t._2, _t._3, _t._4, _t._5, _t._6, f(_t._7), _t._8)
    @inline def map8[X](f: H => X): (A, B, C, D, E, F, G, X) = (_t._1, _t._2, _t._3, _t._4, _t._5, _t._6, _t._7, f(_t._8))
    @inline def put1[X](x: X): (X, B, C, D, E, F, G, H) = (x, _t._2, _t._3, _t._4, _t._5, _t._6, _t._7, _t._8)
    @inline def put2[X](x: X): (A, X, C, D, E, F, G, H) = (_t._1, x, _t._3, _t._4, _t._5, _t._6, _t._7, _t._8)
    @inline def put3[X](x: X): (A, B, X, D, E, F, G, H) = (_t._1, _t._2, x, _t._4, _t._5, _t._6, _t._7, _t._8)
    @inline def put4[X](x: X): (A, B, C, X, E, F, G, H) = (_t._1, _t._2, _t._3, x, _t._5, _t._6, _t._7, _t._8)
    @inline def put5[X](x: X): (A, B, C, D, X, F, G, H) = (_t._1, _t._2, _t._3, _t._4, x, _t._6, _t._7, _t._8)
    @inline def put6[X](x: X): (A, B, C, D, E, X, G, H) = (_t._1, _t._2, _t._3, _t._4, _t._5, x, _t._7, _t._8)
    @inline def put7[X](x: X): (A, B, C, D, E, F, X, H) = (_t._1, _t._2, _t._3, _t._4, _t._5, _t._6, x, _t._8)
    @inline def put8[X](x: X): (A, B, C, D, E, F, G, X) = (_t._1, _t._2, _t._3, _t._4, _t._5, _t._6, _t._7, x)
  }
  @inline final implicit class Tuple9Ext[A, B, C, D, E, F, G, H, I](val _t: (A, B, C, D, E, F, G, H, I)) extends AnyVal {
    @inline def map1[X](f: A => X): (X, B, C, D, E, F, G, H, I) = (f(_t._1), _t._2, _t._3, _t._4, _t._5, _t._6, _t._7, _t._8, _t._9)
    @inline def map2[X](f: B => X): (A, X, C, D, E, F, G, H, I) = (_t._1, f(_t._2), _t._3, _t._4, _t._5, _t._6, _t._7, _t._8, _t._9)
    @inline def map3[X](f: C => X): (A, B, X, D, E, F, G, H, I) = (_t._1, _t._2, f(_t._3), _t._4, _t._5, _t._6, _t._7, _t._8, _t._9)
    @inline def map4[X](f: D => X): (A, B, C, X, E, F, G, H, I) = (_t._1, _t._2, _t._3, f(_t._4), _t._5, _t._6, _t._7, _t._8, _t._9)
    @inline def map5[X](f: E => X): (A, B, C, D, X, F, G, H, I) = (_t._1, _t._2, _t._3, _t._4, f(_t._5), _t._6, _t._7, _t._8, _t._9)
    @inline def map6[X](f: F => X): (A, B, C, D, E, X, G, H, I) = (_t._1, _t._2, _t._3, _t._4, _t._5, f(_t._6), _t._7, _t._8, _t._9)
    @inline def map7[X](f: G => X): (A, B, C, D, E, F, X, H, I) = (_t._1, _t._2, _t._3, _t._4, _t._5, _t._6, f(_t._7), _t._8, _t._9)
    @inline def map8[X](f: H => X): (A, B, C, D, E, F, G, X, I) = (_t._1, _t._2, _t._3, _t._4, _t._5, _t._6, _t._7, f(_t._8), _t._9)
    @inline def map9[X](f: I => X): (A, B, C, D, E, F, G, H, X) = (_t._1, _t._2, _t._3, _t._4, _t._5, _t._6, _t._7, _t._8, f(_t._9))
    @inline def put1[X](x: X): (X, B, C, D, E, F, G, H, I) = (x, _t._2, _t._3, _t._4, _t._5, _t._6, _t._7, _t._8, _t._9)
    @inline def put2[X](x: X): (A, X, C, D, E, F, G, H, I) = (_t._1, x, _t._3, _t._4, _t._5, _t._6, _t._7, _t._8, _t._9)
    @inline def put3[X](x: X): (A, B, X, D, E, F, G, H, I) = (_t._1, _t._2, x, _t._4, _t._5, _t._6, _t._7, _t._8, _t._9)
    @inline def put4[X](x: X): (A, B, C, X, E, F, G, H, I) = (_t._1, _t._2, _t._3, x, _t._5, _t._6, _t._7, _t._8, _t._9)
    @inline def put5[X](x: X): (A, B, C, D, X, F, G, H, I) = (_t._1, _t._2, _t._3, _t._4, x, _t._6, _t._7, _t._8, _t._9)
    @inline def put6[X](x: X): (A, B, C, D, E, X, G, H, I) = (_t._1, _t._2, _t._3, _t._4, _t._5, x, _t._7, _t._8, _t._9)
    @inline def put7[X](x: X): (A, B, C, D, E, F, X, H, I) = (_t._1, _t._2, _t._3, _t._4, _t._5, _t._6, x, _t._8, _t._9)
    @inline def put8[X](x: X): (A, B, C, D, E, F, G, X, I) = (_t._1, _t._2, _t._3, _t._4, _t._5, _t._6, _t._7, x, _t._9)
    @inline def put9[X](x: X): (A, B, C, D, E, F, G, H, X) = (_t._1, _t._2, _t._3, _t._4, _t._5, _t._6, _t._7, _t._8, x)
  }

  // Generated by bin/gen-tuple_ext-homo

  @inline final implicit class HomoTuple2Ext[A](val _t: (A, A)) extends AnyVal {
    @inline def mapEach[B](f: A ⇒ B): (B, B) = (f(_t._1), f(_t._2))
  }
  @inline final implicit class HomoTuple3Ext[A](val _t: (A, A, A)) extends AnyVal {
    @inline def mapEach[B](f: A ⇒ B): (B, B, B) = (f(_t._1), f(_t._2), f(_t._3))
  }
  @inline final implicit class HomoTuple4Ext[A](val _t: (A, A, A, A)) extends AnyVal {
    @inline def mapEach[B](f: A ⇒ B): (B, B, B, B) = (f(_t._1), f(_t._2), f(_t._3), f(_t._4))
  }
  @inline final implicit class HomoTuple5Ext[A](val _t: (A, A, A, A, A)) extends AnyVal {
    @inline def mapEach[B](f: A ⇒ B): (B, B, B, B, B) = (f(_t._1), f(_t._2), f(_t._3), f(_t._4), f(_t._5))
  }
  @inline final implicit class HomoTuple6Ext[A](val _t: (A, A, A, A, A, A)) extends AnyVal {
    @inline def mapEach[B](f: A ⇒ B): (B, B, B, B, B, B) = (f(_t._1), f(_t._2), f(_t._3), f(_t._4), f(_t._5), f(_t._6))
  }
  @inline final implicit class HomoTuple7Ext[A](val _t: (A, A, A, A, A, A, A)) extends AnyVal {
    @inline def mapEach[B](f: A ⇒ B): (B, B, B, B, B, B, B) = (f(_t._1), f(_t._2), f(_t._3), f(_t._4), f(_t._5), f(_t._6), f(_t._7))
  }
  @inline final implicit class HomoTuple8Ext[A](val _t: (A, A, A, A, A, A, A, A)) extends AnyVal {
    @inline def mapEach[B](f: A ⇒ B): (B, B, B, B, B, B, B, B) = (f(_t._1), f(_t._2), f(_t._3), f(_t._4), f(_t._5), f(_t._6), f(_t._7), f(_t._8))
  }
  @inline final implicit class HomoTuple9Ext[A](val _t: (A, A, A, A, A, A, A, A, A)) extends AnyVal {
    @inline def mapEach[B](f: A ⇒ B): (B, B, B, B, B, B, B, B, B) = (f(_t._1), f(_t._2), f(_t._3), f(_t._4), f(_t._5), f(_t._6), f(_t._7), f(_t._8), f(_t._9))
  }

  type HomoTuple2[A] = (A, A)
  type HomoTuple3[A] = (A, A, A)
  type HomoTuple4[A] = (A, A, A, A)
  type HomoTuple5[A] = (A, A, A, A, A)
  type HomoTuple6[A] = (A, A, A, A, A, A)
  type HomoTuple7[A] = (A, A, A, A, A, A, A)
  type HomoTuple8[A] = (A, A, A, A, A, A, A, A)
  type HomoTuple9[A] = (A, A, A, A, A, A, A, A, A)

  type HomoTuple2Map[A,B] = ((A, A)) ⇒ (B, B)
  type HomoTuple3Map[A,B] = ((A, A, A)) ⇒ (B, B, B)
  type HomoTuple4Map[A,B] = ((A, A, A, A)) ⇒ (B, B, B, B)
  type HomoTuple5Map[A,B] = ((A, A, A, A, A)) ⇒ (B, B, B, B, B)
  type HomoTuple6Map[A,B] = ((A, A, A, A, A, A)) ⇒ (B, B, B, B, B, B)
  type HomoTuple7Map[A,B] = ((A, A, A, A, A, A, A)) ⇒ (B, B, B, B, B, B, B)
  type HomoTuple8Map[A,B] = ((A, A, A, A, A, A, A, A)) ⇒ (B, B, B, B, B, B, B, B)
  type HomoTuple9Map[A,B] = ((A, A, A, A, A, A, A, A, A)) ⇒ (B, B, B, B, B, B, B, B, B)

}